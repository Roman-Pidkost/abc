package yurii.shtohman.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurii.shtohman.entity.Human;

import java.util.List;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {

    List<Human> findByFirstNameLike(String name, Sort sort);

}
