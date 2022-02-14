package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.RegionDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Country;
import uz.pdp.entity.Region;
import uz.pdp.repository.CountryRepository;
import uz.pdp.repository.RegionRepository;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    RegionRepository repository;
    @Autowired
    CountryRepository countryRepository;
    public List<Region> get() {
        return repository.findAll();
    }

    public ResponseDto add(RegionDto regionDto) {
        Region region = new Region();
        Country country = countryRepository.getById(regionDto.getCountryId());
        region.setCountry(country);
        region.setName(regionDto.getName());
       repository.save(region);
        return  new ResponseDto("Added",true,region);
    }

    public String del(Integer id) {
        if (!repository.findById(id).isPresent()){
            return "Not found";
        }
        repository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto upd(Integer id, RegionDto regionDto) {
        if (!repository.findById(id).isPresent()){
            return new ResponseDto("Not found",false,null);
        }
        Region region = repository.getById(id);
        Country country = countryRepository.getById(regionDto.getCountryId());
        region.setName(regionDto.getName());
        region.setCountry(country);
        Region save = repository.save(repository.getById(id));
        return new ResponseDto("Updated",true,save);
    }
}
