package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.University;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {
}
