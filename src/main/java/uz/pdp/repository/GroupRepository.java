package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Faculty;
import uz.pdp.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Integer> {
}
