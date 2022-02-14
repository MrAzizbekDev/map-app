package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.StudentDto;
import uz.pdp.entity.Student;
import uz.pdp.entity.Subject;
import uz.pdp.service.StudentService;
import uz.pdp.service.SubjectService;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/subject")
    public List<Subject> get() {
        return subjectService.get();
    }

    @PostMapping("/subject")
    public ResponseDto add(@RequestBody RequestDto requestDto) {
        return subjectService.add(requestDto);
    }

    @DeleteMapping("/subject/{id}")
    public String del(@PathVariable Integer id) {
        return subjectService.del(id);
    }

    @PutMapping("/subject/{id}")
    public ResponseDto upd(@PathVariable Integer id,
                           @RequestBody RequestDto requestDto) {
        return subjectService.put(requestDto, id);
    }
}
