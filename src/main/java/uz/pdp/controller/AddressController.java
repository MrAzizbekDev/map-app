package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.AddressDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Address;
import uz.pdp.service.AddressService;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/address")
    public ResponseDto add(@RequestBody AddressDto addressDto){
        return addressService.add(addressDto);
    }
    @GetMapping("/address")
    public List<Address> get(){
        return addressService.get();
    }
    @DeleteMapping("/address/{id}")
    public String del(@PathVariable Integer id){
        return addressService.del(id);
    }
    @PutMapping("/address/{id}")
    public ResponseDto put(@PathVariable Integer id,
                           @RequestBody AddressDto addressDto){
        return addressService.put(id,addressDto);
    }
}
