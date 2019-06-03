package yurii.shtohman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import yurii.shtohman.dto.request.HumanRequest;
import yurii.shtohman.dto.request.VacanciesRequest;
import yurii.shtohman.entity.Human;
import yurii.shtohman.entity.Vacancies;
import yurii.shtohman.service.VacanciesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vacancies")
public class VacanciesController {

    @Autowired
    private VacanciesService vacanciesService;


    @PostMapping
    public void create(@RequestBody VacanciesRequest vacanciesRequest){
        vacanciesService.create(vacanciesRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody VacanciesRequest vacanciesRequest){
        vacanciesService.update(id,vacanciesRequest);
    }

    @GetMapping
    public List<Vacancies> get(String sortBy, Sort.Direction direction, String name){
        return vacanciesService.getAll(sortBy, direction, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vacanciesService.delete(id);
    }

}
