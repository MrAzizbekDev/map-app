package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Subject;
import uz.pdp.entity.University;

public interface SubjectRepository extends JpaRepository<Subject ,Integer> {
}
