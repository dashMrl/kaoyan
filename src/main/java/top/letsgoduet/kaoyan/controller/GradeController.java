package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.Grade;
import top.letsgoduet.kaoyan.repo.GradeRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/grade")
public class GradeController {
    @Autowired
    private GradeRepo gradeRepo;


    @PutMapping(path = "/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestParam(name = "title")String title,
                       @RequestParam(name = "content")String content,
                       HttpServletRequest request,
                       HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        if (!AdminUtil.isAdmin(CookieHelper.decodeCookie2UID(request.getCookies()))) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        Optional<Grade> byId = gradeRepo.findById(id);
        if (byId.isPresent()) {
            Grade grade = byId.get();
            grade.title = title.isEmpty() ? grade.title : title;
            grade.content = content.isEmpty() ? grade.content : content;
            gradeRepo.save(grade);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @GetMapping(path = "/{sid}")
    public List<Grade> get(@PathVariable(name = "sid") Long sid) {
        List<Grade> allBySId = gradeRepo.findAllBySId(sid);

        return allBySId;
    }
}
