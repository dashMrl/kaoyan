package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.Outline;
import top.letsgoduet.kaoyan.repo.OutlineRepo;

import java.util.List;

@RestController
@RequestMapping(path = "/outline")
public class OutlineController {
    @Autowired
    private OutlineRepo outlineRepo;

    @GetMapping(path = "/{sid}")
    public List<Outline> get(@PathVariable(name = "sid") Long sid) {
        List<Outline> allBySId = outlineRepo.findAllBySId(sid);
        return allBySId;
    }
}
