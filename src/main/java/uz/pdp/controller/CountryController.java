package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.CountryDto;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Country;
import uz.pdp.service.CountryService;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;
    @PostMapping("/country")
    public ResponseDto pos(@RequestBody CountryDto countryDto){
        return countryService.post(countryDto);
    }
    @GetMapping("/country")
    public List<Country> get(){
        return countryService.get();
    }
    @PutMapping("/country/{id}")
    public ResponseDto put(@PathVariable Integer id,
                           @RequestBody CountryDto countryDto){
        return countryService.put(id,countryDto);
    }
    @DeleteMapping("/country/{id}")
    public String del(@PathVariable Integer id){
        return countryService.del(id);
    }
}
