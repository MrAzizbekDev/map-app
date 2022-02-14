package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.TeacherDto;
import uz.pdp.entity.Group;
import uz.pdp.entity.Subject;
import uz.pdp.entity.Teacher;
import uz.pdp.repository.GroupRepository;
import uz.pdp.repository.SubjectRepository;
import uz.pdp.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectRepository subjectRepository;
     @Autowired
    GroupRepository groupRepository;
    public List<Teacher> get() {
        return teacherRepository.findAll();
    }

    public ResponseDto put(TeacherDto teacherDto, Integer id) {
        if (!teacherRepository.findById(id).isPresent()) {
            return new ResponseDto("Not found", false, null);
        }
        List<Subject> subjects = subjectRepository.findAllById(teacherDto.getSubjectId());
        List<Group> groups = groupRepository.findAllById(teacherDto.getGroups());
        Teacher teacher = teacherRepository.getById(id);
        teacher.setName(teacherDto.getName());
        teacher.setSubjects(subjects);
        teacher.setGroups(groups);
        Teacher save = teacherRepository.save(teacher);
        return new ResponseDto("Updated", true, save);
    }

    public String del(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            return ("Not Found");
        }
        teacherRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto add(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        List<Group> groups = groupRepository.findAllById(teacherDto.getGroups());
        List<Subject> subject = subjectRepository.findAllById(teacherDto.getSubjectId());
        teacher.setName(teacherDto.getName());
        teacher.setSubjects(subject);
        teacher.setGroups(groups);
        Teacher save = teacherRepository.save(teacher);
        return new ResponseDto("Added", true, save);
    }
}
