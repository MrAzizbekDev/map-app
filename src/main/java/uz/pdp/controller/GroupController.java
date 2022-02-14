package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.FacultyDto;
import uz.pdp.dto.GroupDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.Group;
import uz.pdp.service.FacultyService;
import uz.pdp.service.GroupService;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    GroupService groupService;
    @GetMapping("/group")
    public List<Group> get(){
        return groupService.get();
    }
    @PostMapping ("/group")
    public ResponseDto add(@RequestBody GroupDto groupDto){
        return groupService.add(groupDto);
    }
    @DeleteMapping("/group/{id}")
    public String del(@PathVariable Integer id){
        return groupService.del(id);
    }
    @PutMapping("/group/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody GroupDto groupDto){
        return groupService.upd(id,groupDto);
    }
}
