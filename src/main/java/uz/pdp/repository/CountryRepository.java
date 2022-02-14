package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
