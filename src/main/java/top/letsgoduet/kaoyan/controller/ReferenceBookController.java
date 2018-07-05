
package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.ReferenceBook;
import top.letsgoduet.kaoyan.repo.ReferenceBookRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/refbook")
public class ReferenceBookController {
    @Autowired
    private ReferenceBookRepo referenceBookRepo;
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
        Optional<ReferenceBook> byId = referenceBookRepo.findById(id);
        if (byId.isPresent()) {
            ReferenceBook referenceBook = byId.get();
            referenceBook.title = title.isEmpty() ? referenceBook.title : title;
            referenceBook.content = content.isEmpty() ? referenceBook.content : content;
            referenceBookRepo.save(referenceBook);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @GetMapping(path = "/{sid}")
    public List<ReferenceBook> get(@PathVariable(name = "sid") Long sid) {
        List<ReferenceBook> allBySId = referenceBookRepo.findAllBySId(sid);
        return allBySId;
    }
}
