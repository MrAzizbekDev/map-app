package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.GroupDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.StudentDto;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.Group;
import uz.pdp.entity.Student;
import uz.pdp.repository.FacultyRepository;
import uz.pdp.repository.GroupRepository;
import uz.pdp.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<Student> get() {
        return studentRepository.findAll();
    }

    public ResponseDto add(StudentDto studentDto) {
        Student student = new Student();
        Group group = groupRepository.getById(studentDto.getGroupId());
        student.setName(studentDto.getName());
        student.setGroup(group);
        ResponseDto added = new ResponseDto("Added", true, student);
        return added;
    }

    public String del(Integer id) {
        if (!studentRepository.findById(id).isPresent()) {
            return "Not found";
        }
        studentRepository.deleteById(id);
        return "Deleted";
    }
    public ResponseDto upd(Integer id, StudentDto studentDto) {
        if (!studentRepository.findById(id).isPresent()) {
            return new ResponseDto("Not found", false, null);
        }
        Group group = groupRepository.getById(studentDto.getGroupId());
        Student student = studentRepository.getById(id);
        student.setName(studentDto.getName());
        student.setGroup(group);
        Student save = studentRepository.save(student);
        return new ResponseDto("Updated",true,save);
    }
}
