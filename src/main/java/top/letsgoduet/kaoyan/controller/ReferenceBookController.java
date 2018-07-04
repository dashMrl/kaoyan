
package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.ReferenceBook;
import top.letsgoduet.kaoyan.repo.ReferenceBookRepo;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/refbook")
public class ReferenceBookController {
    @Autowired
    private ReferenceBookRepo referenceBookRepo;
    @GetMapping(path = "/{sid}")
    public List<ReferenceBook> get(@PathVariable(name = "sid") Long sid) {
        List<ReferenceBook> allBySId = referenceBookRepo.findAllBySId(sid);
        return allBySId;
    }
}
