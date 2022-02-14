package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.DistrictDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.District;
import uz.pdp.service.DistrictService;

import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @PostMapping("/district")
    public ResponseDto add(@RequestBody DistrictDto districtDto){
        return districtService.add(districtDto);
    }
    @GetMapping("/district")
    public List<District> get(){
        return districtService.get();
    }
    @DeleteMapping("/district/{id}")
    public String del(@PathVariable Integer id){
        return districtService.del(id);
    }
    @PutMapping("/district/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody DistrictDto districtDto){
        return districtService.upd(id,districtDto);
    }
}
