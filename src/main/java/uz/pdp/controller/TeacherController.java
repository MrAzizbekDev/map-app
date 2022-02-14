package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.TeacherDto;
import uz.pdp.entity.Teacher;
import uz.pdp.service.TeacherService;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher")
    public List<Teacher> get() {
        return teacherService.get();
    }

    @PostMapping("/teacher")
    public ResponseDto add(@RequestBody TeacherDto teacherDto) {
        return teacherService.add(teacherDto);
    }

    @DeleteMapping("/teacher/{id}")
    public String del(@PathVariable Integer id) {
        return teacherService.del(id);
    }

    @PutMapping("/teacher/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody TeacherDto teacherDto) {
        return teacherService.put(teacherDto, id);
    }
}
