package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.RegionDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.UniversityDto;
import uz.pdp.entity.Region;
import uz.pdp.entity.University;
import uz.pdp.service.RegionService;
import uz.pdp.service.UniversityService;

import java.util.List;

@RestController
public class UniversityController {
    @Autowired
    UniversityService universityService;
    @GetMapping("/university")
    public List<University> get(){
        return universityService.get();
    }
    @PostMapping ("/university")
    public ResponseDto add(@RequestBody UniversityDto universityDto){
        return universityService.add(universityDto);
    }
    @DeleteMapping("/university/{id}")
    public String del(@PathVariable Integer id){
        return universityService.del(id);
    }
    @PutMapping("/university/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody UniversityDto universityDto){
        return universityService.upd(id,universityDto);
    }
}
