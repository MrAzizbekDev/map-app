package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.RegionDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.UniversityDto;
import uz.pdp.entity.Address;
import uz.pdp.entity.University;
import uz.pdp.repository.AddressRepository;
import uz.pdp.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;
    public List<University> get() {
        return universityRepository.findAll();
    }

    public ResponseDto add(UniversityDto universityDto) {
        Address address = addressRepository.getById(universityDto.getAddressId());
        University university = new University();
        university.setName(universityDto.getName());
        university.setAddress(address);
        University save = universityRepository.save(university);
        return new ResponseDto("Added",true,save);
    }

    public String del(Integer id) {
        if (!universityRepository.findById(id).isPresent()){
            return "Not found";
        }
        universityRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto upd(Integer id, UniversityDto universityDto) {
        if (!universityRepository.findById(id).isPresent()){
            return new ResponseDto("Not found",false,null);
        }
        University university = universityRepository.getById(id);
        Address address = addressRepository.getById(universityDto.getAddressId());
        university.setName(universityDto.getName());
        university.setAddress(address);
        University save = universityRepository.save(university);
        final ResponseDto updated = new ResponseDto("Updated", true, save);
        return updated;
    }
}
