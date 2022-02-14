package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.RequestDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Continent;
import uz.pdp.entity.Subject;
import uz.pdp.repository.ContinentRepository;
import uz.pdp.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> get() {
        return subjectRepository.findAll();
    }

    public ResponseDto put(RequestDto requestDto, Integer id) {
        if (!subjectRepository.findById(id).isPresent()) {
            return new ResponseDto("Not found", false, null);
        }
        Subject subject = subjectRepository.getById(id);
        subject.setName(requestDto.getName());
        Subject save = subjectRepository.save(subject);
        return new ResponseDto("Updated", true, save);
    }

    public String del(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (!subject.isPresent()) {
            return ("Not Found");
        }
        subjectRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto add(RequestDto requestDto) {
        Subject subject = new Subject();
        subject.setName(requestDto.getName());
        Subject save = subjectRepository.save(subject);
        return new ResponseDto("Added", true, save);
    }
}
