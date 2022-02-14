package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.FacultyDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.UniversityDto;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.University;
import uz.pdp.service.FacultyService;
import uz.pdp.service.UniversityService;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    FacultyService facultyService;
    @GetMapping("/faculty")
    public List<Faculty> get(){
        return facultyService.get();
    }
    @PostMapping ("/faculty")
    public ResponseDto add(@RequestBody FacultyDto facultyDto){
        return facultyService.add(facultyDto);
    }
    @DeleteMapping("/faculty/{id}")
    public String del(@PathVariable Integer id){
        return facultyService.del(id);
    }
    @PutMapping("/faculty/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody FacultyDto facultyDto){
        return facultyService.upd(id,facultyDto);
    }
}
