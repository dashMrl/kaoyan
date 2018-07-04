package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.repo.EnrollmentRegulationRepo;

import java.util.List;

@RestController
@RequestMapping(path = "/enrollreg")
public class EnrollmentRegulationController {
    @Autowired
    private EnrollmentRegulationRepo enrRepo;

    @GetMapping(path = "/{sid}")
    public List<EnrollmentRegulation> get(@PathVariable(name = "sid") Long sid) {
        return enrRepo.findAllBySId(sid);
    }
}
