package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.Major;
import top.letsgoduet.kaoyan.repo.MajorRepo;

import java.util.List;

@RestController
@RequestMapping(path = "/major")
public class MajorController {
    @Autowired
    private MajorRepo majorRepo;

    @GetMapping(path = "/{sid}")
    public List<Major> get(@PathVariable(name = "sid") Long sid) {
        List<Major> allBySId = majorRepo.findAllBySId(sid);

        return allBySId;
    }
}
