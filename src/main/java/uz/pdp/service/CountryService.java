package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.CountryDto;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Continent;
import uz.pdp.entity.Country;
import uz.pdp.repository.ContinentRepository;
import uz.pdp.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    ContinentRepository continentRepository;
    @Autowired
    CountryRepository countryRepository;

    public ResponseDto post(CountryDto countryDto) {
        Optional<Continent> continent = continentRepository.findById(countryDto.getContinentId());
        if (!continent.isPresent()) {
            return new ResponseDto("Not found such Continent", false, null);
        }
        Continent byId = continentRepository.getById(countryDto.getContinentId());
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setContinent(byId);
        return new ResponseDto("Added",true,countryRepository.save(country));
    }


    public List<Country> get() {
        return countryRepository.findAll();
    }

    public ResponseDto put(Integer id, CountryDto countryDto) {
        Optional<Country> countryId = countryRepository.findById(id);
        Continent continent = continentRepository.getById(countryDto.getContinentId());
        if (!countryId.isPresent()){
            return new ResponseDto("Not found",false,null);
        }
        Country country = countryRepository.getById(id);
        country.setName(countryDto.getName());
        country.setContinent(continent);
        Country save = countryRepository.save(country);
        return new ResponseDto("Updated",true,save);
    }

    public String del(Integer id) {
        Optional<Country> countryId = countryRepository.findById(id);
        if (!countryId.isPresent()){
            return ("Not found");
        }
        countryRepository.deleteById(id);
        return "Deleted";
    }
}
