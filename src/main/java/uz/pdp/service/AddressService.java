package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.AddressDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Address;
import uz.pdp.entity.District;
import uz.pdp.repository.AddressRepository;
import uz.pdp.repository.DistrictRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DistrictRepository districtRepository;
    public ResponseDto add(AddressDto addressDto) {
        District distict = districtRepository.getById(addressDto.getDistrictId());
        Address address = new Address();
        address.setName(addressDto.getName());
        address.setHomeNum(addressDto.getHomeNum());
        address.setDistrict(distict);
        Address save = addressRepository.save(address);
        return new ResponseDto("Added",true,save);
    }

    public List<Address> get() {
        return addressRepository.findAll();
    }

    public String del(Integer id) {
        if (!addressRepository.findById(id).isPresent()){
            return "Not found";
        }
        addressRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto put(Integer id, AddressDto addressDto) {
        if (!addressRepository.findById(id).isPresent()){
            return new ResponseDto("Not found",false,null);
        }
        District district = districtRepository.getById(addressDto.getDistrictId());
        Address address = addressRepository.getById(id);
        address.setName(addressDto.getName());
        address.setHomeNum(addressDto.getHomeNum());
        address.setDistrict(district);
        Address save = addressRepository.save(address);
        return new ResponseDto("Updated",true,save);
    }
}
