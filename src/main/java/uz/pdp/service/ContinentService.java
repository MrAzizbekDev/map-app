package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Continent;
import uz.pdp.repository.ContinentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {
    @Autowired
    ContinentRepository continentRepository;
    public ResponseDto pos(RequestDto requestDto) {
        Continent continent = new Continent();
        continent.setName(requestDto.getName());
        Continent save = continentRepository.save(continent);
        return new ResponseDto("Added",true,save);
    }

    public List<Continent> get() {
        return continentRepository.findAll();
    }

    public ResponseDto put(RequestDto requestDto, Integer id) {
        Optional<Continent> continent1 = continentRepository.findById(id);
        if (!continent1.isPresent()){
            return new ResponseDto("Not Found",false,null);
        }
        Continent continent = continentRepository.getById(id);
        continent.setName(requestDto.getName());
        Continent save = continentRepository.save(continent);
        return new ResponseDto("Updated",true,save);
    }

    public String del(Integer id) {
        Optional<Continent> continent1 = continentRepository.findById(id);
        if (!continent1.isPresent()){
            return ("Not Found");
        }
        continentRepository.deleteById(id);
        return "Deleted";
    }
}
