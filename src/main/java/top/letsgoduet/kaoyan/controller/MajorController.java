package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.Major;
import top.letsgoduet.kaoyan.repo.MajorRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/major")
public class MajorController {
    @Autowired
    private MajorRepo majorRepo;
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
        Optional<Major> byId = majorRepo.findById(id);
        if (byId.isPresent()) {
            Major major = byId.get();
            major.title = title.isEmpty() ? major.title : title;
            major.content = content.isEmpty() ? major.content : content;
            majorRepo.save(major);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @GetMapping(path = "/{sid}")
    public List<Major> get(@PathVariable(name = "sid") Long sid) {
        List<Major> allBySId = majorRepo.findAllBySId(sid);

        return allBySId;
    }
}
