package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.RegionDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Region;
import uz.pdp.service.RegionService;

import java.util.List;

@RestController
public class RegionController {
    @Autowired
    RegionService regionService;
    @GetMapping("/region")
    public List<Region> get(){
        return regionService.get();
    }
    @PostMapping ("/region")
    public ResponseDto add(@RequestBody RegionDto regionDto){
        return regionService.add(regionDto);
    }
    @DeleteMapping("/region/{id}")
    public String del(@PathVariable Integer id){
        return regionService.del(id);
    }
    @PutMapping("/region/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody RegionDto regionDto){
        return regionService.upd(id,regionDto);
    }
}
