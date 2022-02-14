package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.District;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
