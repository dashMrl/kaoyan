package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.School;
import top.letsgoduet.kaoyan.repo.SchoolRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {
    @Autowired
    private SchoolRepo schoolRepo;
    @GetMapping(path = "/detail")
    public School getSchool(@RequestParam(name = "id") Long id){
        Optional<School> optionalSchool = schoolRepo.findById(id);
        return optionalSchool.orElse(null);
    }

    @GetMapping(path = "/all")
    public List<School> getAllSchools() {
        List<School> ss = new ArrayList<>();
        schoolRepo.findAll().forEach(ss::add);
        return ss;
    }
}
