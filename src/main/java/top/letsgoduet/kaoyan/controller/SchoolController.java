package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.School;
import top.letsgoduet.kaoyan.repo.SchoolRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {
    @Autowired
    private SchoolRepo schoolRepo;


    @PutMapping(path = "/{id}")
    public void updateById(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "intro") String intro,
            @RequestParam(name = "district") String district,
            @RequestParam(name = "site") String site,
            @RequestParam(name = "cover") String cover,
            @RequestParam(name = "logo") String logo,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (!AdminUtil.isAdmin(CookieHelper.decodeCookie2UID(request.getCookies()))) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        Optional<School> byId = schoolRepo.findById(id);
        if (byId.isPresent()) {
            School school = byId.get();
            school.name = name.isEmpty() ? school.name : name;
            school.intro = intro.isEmpty() ? school.intro : intro;
            school.district = district.isEmpty() ? school.district : district;
            school.site = site.isEmpty() ? school.site : site;
            school.cover = cover.isEmpty() ? school.cover : cover;
            school.logo = logo.isEmpty() ? school.logo : logo;
            schoolRepo.save(school);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public School findById(@PathVariable(name = "id") Long id,
                           HttpServletResponse response) {
        Optional<School> byId = schoolRepo.findById(id);
        if (byId.isPresent()) {
            School school = byId.get();
            school.pv++;
            return schoolRepo.save(school);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @GetMapping(path = "/all")
    public List<School> findAllSchool() {
        List<School> ss = new ArrayList<>();
        schoolRepo.findAll().forEach(ss::add);
        return ss;
    }
}
