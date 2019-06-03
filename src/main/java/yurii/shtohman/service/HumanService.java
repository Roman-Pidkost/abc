package yurii.shtohman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yurii.shtohman.dto.request.HumanRequest;
import yurii.shtohman.entity.Human;
import yurii.shtohman.repository.HumanRepository;

import java.util.List;

@Service
public class HumanService {


    @Autowired
    private HumanRepository humanRepository;

    public void create(HumanRequest humanRequest) {
        humanRepository.save(toEntity(null, humanRequest));
    }

    public void update(Long id, HumanRequest humanRequest) {
        Human human = findOne(id);
        humanRepository.save(toEntity(human, humanRequest));
    }

    public List<Human> getAll(String sortBy, Sort.Direction direction, String name) {
        if (name != null && !name.isEmpty()) {
            return humanRepository.findByFirstNameLike("%"+name+"%", Sort.by(direction, sortBy));
        } else {
            return humanRepository.findAll(Sort.by(direction, sortBy));
        }
    }

    public void delete(Long id) {
        Human human = findOne(id);
        humanRepository.delete(human);
    }

    private Human findOne(Long id) {
        return humanRepository.findById(id).orElseThrow(() -> new RuntimeException("Human not found"));
    }

    private Human toEntity(Human human, HumanRequest humanRequest) {
        if (human == null) {
            human = new Human();
        }
        human.setFirstName(humanRequest.getFirstName());
        human.setLastName(humanRequest.getLastName());
        human.setDescription(humanRequest.getDescription());
        human.setDateOfBirth(humanRequest.getDateOfBirth());
        human.setIndustry(humanRequest.getIndustry());
        human.setSalary(humanRequest.getSalary());
        return human;
    }

}


