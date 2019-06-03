package yurii.shtohman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import yurii.shtohman.dto.request.HumanRequest;
import yurii.shtohman.entity.Human;
import yurii.shtohman.service.HumanService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/human")
public class HumanController {

    @Autowired
    private HumanService humanService;

    @PostMapping
    public void create(@RequestBody HumanRequest humanRequest){
       humanService.create(humanRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody HumanRequest humanRequest){
        humanService.update(id,humanRequest);
    }

    @GetMapping
    public List<Human> get(String sortBy, Sort.Direction direction, String name){
        return humanService.getAll(sortBy, direction, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        humanService.delete(id);
    }

}
