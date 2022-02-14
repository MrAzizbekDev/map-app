package uz.pdp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Continent;
import uz.pdp.service.ContinentService;

import java.util.List;

@RestController
public class ContinentController {
    @Autowired
    ContinentService continentService;

    @GetMapping("/continent")
      public List<Continent> get(){
        return continentService.get();
    }
    @PostMapping("/continent")
     ResponseDto post(@RequestBody RequestDto requestDto) {
        return continentService.pos(requestDto);
    }
    @PutMapping("/continent/{id}")
    public ResponseDto put(@RequestBody RequestDto requestDto,
                           @PathVariable Integer id){
        return continentService.put(requestDto,id);
    }
    @DeleteMapping("/continent/{id}")
    public String del(@PathVariable Integer id){
        return continentService.del(id);
    }
}
