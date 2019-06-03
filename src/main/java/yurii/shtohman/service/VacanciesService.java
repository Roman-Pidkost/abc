package yurii.shtohman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yurii.shtohman.dto.request.VacanciesRequest;
import yurii.shtohman.entity.Vacancies;
import yurii.shtohman.repository.VacanciesRepository;

import java.util.List;

@Service
public class VacanciesService {
    
    @Autowired
    private VacanciesRepository vacanciesRepository;

    public void create(VacanciesRequest vacanciesRequest) {
        vacanciesRepository.save(toEntity(null, vacanciesRequest));
    }

    public void update(Long id, VacanciesRequest vacanciesRequest) {
        Vacancies vacancies = findOne(id);
        vacanciesRepository.save(toEntity(vacancies, vacanciesRequest));
    }

    public List<Vacancies> getAll(String sortBy, Sort.Direction direction, String name) {
        if (name != null && !name.isEmpty()) {
            return vacanciesRepository.findByNameLike("%"+name+"%", Sort.by(direction, sortBy));
        } else {
            return vacanciesRepository.findAll(Sort.by(direction, sortBy));
        }
    }

    public void delete(Long id) {
        Vacancies vacancies = findOne(id);
        vacanciesRepository.delete(vacancies);
    }

    private Vacancies findOne(Long id) {
        return vacanciesRepository.findById(id).orElseThrow(() -> new RuntimeException("Human not found"));
    }

    private Vacancies toEntity(Vacancies vacancies, VacanciesRequest vacanciesRequest) {
        if (vacancies == null) {
            vacancies = new Vacancies();
        }
        vacancies.setName(vacanciesRequest.getName());
        vacancies.setCity(vacanciesRequest.getCity());
        vacancies.setNameOfCompany(vacanciesRequest.getNameOfCompany());
        vacancies.setDescription(vacanciesRequest.getDescription());
        vacancies.setSalary(vacanciesRequest.getSalary());
        return vacancies;
    }
    
    
    
}
