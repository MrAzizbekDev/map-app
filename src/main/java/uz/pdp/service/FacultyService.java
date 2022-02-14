package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.FacultyDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.dto.UniversityDto;
import uz.pdp.entity.Address;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.University;
import uz.pdp.repository.AddressRepository;
import uz.pdp.repository.FacultyRepository;
import uz.pdp.repository.UniversityRepository;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public List<Faculty> get() {
        return facultyRepository.findAll();
    }

    public ResponseDto add(FacultyDto facultyDto) {
        University university = universityRepository.getById(facultyDto.getUniverId());
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        faculty.setUniversity(university);
        Faculty save = facultyRepository.save(faculty);
        ResponseDto added = new ResponseDto("Added", true, faculty);
        return added;
    }

    public String del(Integer id) {
        if (!universityRepository.findById(id).isPresent()) {
            return "Not found";
        }
        universityRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto upd(Integer id, FacultyDto facultyDto) {
        if (!facultyRepository.findById(id).isPresent()) {
            return new ResponseDto("Not found", false, null);
        }
        Faculty faculty = facultyRepository.getById(id);
        University univer = universityRepository.getById(facultyDto.getUniverId());
        faculty.setName(facultyDto.getName());
        faculty.setUniversity(univer);
        Faculty save = facultyRepository.save(faculty);
        final ResponseDto updated = new ResponseDto("Updated", true, save);
        return updated;
    }
}
