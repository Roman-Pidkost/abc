package yurii.shtohman.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurii.shtohman.entity.Human;
import yurii.shtohman.entity.Vacancies;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies, Long> {
    List<Vacancies> findByNameLike(String name, Sort sort);

}
