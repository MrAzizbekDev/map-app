package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Region;
import uz.pdp.entity.University;

public interface UniversityRepository extends JpaRepository<University,Integer> {
}
