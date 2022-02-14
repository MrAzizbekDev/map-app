package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dto.FacultyDto;
import uz.pdp.dto.GroupDto;
import uz.pdp.dto.ResponseDto;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.Group;
import uz.pdp.entity.University;
import uz.pdp.repository.FacultyRepository;
import uz.pdp.repository.GroupRepository;
import uz.pdp.repository.UniversityRepository;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public List<Group> get() {
        return groupRepository.findAll();
    }

    public ResponseDto add(GroupDto groupDto) {
        Group group = new Group();
        Faculty faculty = facultyRepository.getById(groupDto.getFacultyId());
        group.setName(groupDto.getName());
        group.setFaculty(faculty);
        Group save = groupRepository.save(group);
        ResponseDto added = new ResponseDto("Added", true);
        return added;
    }

    public String del(Integer id) {
        if (!groupRepository.findById(id).isPresent()) {
            return "Not found";
        }
        groupRepository.deleteById(id);
        return "Deleted";
    }

    public ResponseDto upd(Integer id, GroupDto groupDto) {
        if (!groupRepository.findById(id).isPresent()) {
            return new ResponseDto("Not found", false, null);
        }
        Group group = groupRepository.getById(id);
        Faculty faculty = facultyRepository.getById(groupDto.getFacultyId());
        group.setName(groupDto.getName());
        group.setFaculty(faculty);
        Group save = groupRepository.save(group);
        final ResponseDto updated = new ResponseDto("Updated", true, save);
        return updated;
    }
}
