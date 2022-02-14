package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.GroupDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.StudentDto;
import uz.pdp.entity.Student;
import uz.pdp.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student")
    public List<Student> get(){
        return studentService.get();
    }
    @PostMapping ("/student")
    public ResponseDto add(@RequestBody StudentDto studentDto){
        return studentService.add(studentDto);
    }
    @DeleteMapping("/student/{id}")
    public String del(@PathVariable Integer id){
        return studentService.del(id);
    }
    @PutMapping("/student/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody StudentDto studentDto){
        return studentService.upd(id,studentDto);
    }
}
