package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Continent;

public interface ContinentRepository extends JpaRepository<Continent,Integer> {
}
