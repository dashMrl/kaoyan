package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.Grade;
import top.letsgoduet.kaoyan.repo.GradeRepo;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/grade")
public class GradeController {
    @Autowired
    private GradeRepo gradeRepo;

    @GetMapping(path = "/{sid}")
    public List<Grade> get(@PathVariable(name = "sid") Long sid) {
        List<Grade> allBySId = gradeRepo.findAllBySId(sid);

        return allBySId;
    }
}
