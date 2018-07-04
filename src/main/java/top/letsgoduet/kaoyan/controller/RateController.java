package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.Rate;
import top.letsgoduet.kaoyan.repo.RateRepo;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/rate")
public class RateController {
    @Autowired
    private RateRepo rateRepo;
    @GetMapping(path = "/{sid}")
    public List<Rate> get(@PathVariable(name = "sid") Long sid) {
        List<Rate> allBySId = rateRepo.findAllBySId(sid);
        return allBySId;
    }
}
