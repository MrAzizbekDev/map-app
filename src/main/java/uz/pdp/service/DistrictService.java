package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.DistrictDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Country;
import uz.pdp.entity.District;
import uz.pdp.entity.Region;
import uz.pdp.repository.CountryRepository;
import uz.pdp.repository.DistrictRepository;
import uz.pdp.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    RegionRepository regionRepository;
    public ResponseDto add(DistrictDto districtDto) {
        Optional<Region> region = regionRepository.findById(districtDto.getRegionId());
        if (!region.isPresent()){
            return new ResponseDto("Not Found",false,null);
        }
        District district = new District();
        district.setName(districtDto.getName());
        district.setRegion(region.get());
        District save = districtRepository.save(district);
        return new ResponseDto("Added",true,save);
    }

    public List<District> get() {
        return districtRepository.findAll();
    }

    public String del(Integer id) {
        Optional<District> district = districtRepository.findById(id);
        if (!district.isPresent()){
            return "Not found";
        }
        districtRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto upd(Integer id, DistrictDto districtDto) {
        Optional<District> dist = districtRepository.findById(id);
        if (!dist.isPresent()){
            return new ResponseDto("Not Found",true,null);
        }
        District district = districtRepository.getById(id);
        Region region = regionRepository.getById(districtDto.getRegionId());
        district.setName(districtDto.getName());
        district.setRegion(region);
        District save = districtRepository.save(district);
        return new ResponseDto("Chaned",true,save);
    }
}
