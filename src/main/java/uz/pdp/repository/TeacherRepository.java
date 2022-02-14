package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Teacher;
import uz.pdp.entity.University;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
