package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.Outline;
import top.letsgoduet.kaoyan.repo.OutlineRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/outline")
public class OutlineController {
    @Autowired
    private OutlineRepo outlineRepo;

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
        Optional<Outline> byId = outlineRepo.findById(id);
        if (byId.isPresent()) {
            Outline outline = byId.get();
            outline.title = title.isEmpty() ? outline.title : title;
            outline.content = content.isEmpty() ? outline.content : content;
            outlineRepo.save(outline);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @GetMapping(path = "/{sid}")
    public List<Outline> get(@PathVariable(name = "sid") Long sid) {
        List<Outline> allBySId = outlineRepo.findAllBySId(sid);
        return allBySId;
    }
}
