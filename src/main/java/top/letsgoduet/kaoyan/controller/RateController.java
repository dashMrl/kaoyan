package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.Rate;
import top.letsgoduet.kaoyan.repo.RateRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rate")
public class RateController {
    @Autowired
    private RateRepo rateRepo;

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
        Optional<Rate> byId = rateRepo.findById(id);
        if (byId.isPresent()) {
            Rate rate = byId.get();
            rate.title = title.isEmpty() ? rate.title : title;
            rate.content = content.isEmpty() ? rate.content : content;
            rateRepo.save(rate);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @GetMapping(path = "/{sid}")
    public List<Rate> get(@PathVariable(name = "sid") Long sid) {
        List<Rate> allBySId = rateRepo.findAllBySId(sid);
        return allBySId;
    }
}
