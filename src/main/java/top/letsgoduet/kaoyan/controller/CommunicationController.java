package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.Communication;
import top.letsgoduet.kaoyan.repo.CommunicationRepo;
import top.letsgoduet.kaoyan.repo.UserRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comm")
public class CommunicationController {

    @Autowired
    private CommunicationRepo commRepo;
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "")
    public Communication createComm(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam(name = "title") String title,
                                    @RequestParam(name = "content") String content) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        long uid = CookieHelper.decodeCookie2UID(request.getCookies());
        if (userRepo.existsById(uid)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        if (title.isEmpty() || content.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        Communication comm = new Communication();
        comm.uId = uid;
        comm.title = title;
        comm.content = content;
        comm.createTime = comm.updateTime = new Date();
        if (AdminUtil.isAdmin(uid)) {
            comm.level = Communication.LEVEL_HIGH;
        } else {
            comm.level = Communication.LEVEL_LOW;
        }
        return commRepo.save(comm);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteComm(
            @PathVariable(name = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        long uid = CookieHelper.decodeCookie2UID(request.getCookies());
        if (userRepo.existsById(uid)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (!commRepo.existsById(id)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else if (commRepo.findById(id).get().uId == uid) {
            commRepo.deleteById(id);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @PutMapping(path = "/{id}")
    public Communication updateComm(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        long uid = CookieHelper.decodeCookie2UID(request.getCookies());
        if (userRepo.existsById(uid)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        Optional<Communication> byId = commRepo.findById(id);
        if (!byId.isPresent()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        if (uid != byId.get().uId) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        Communication comm = byId.get();
        comm.title = title.isEmpty() ? comm.title : title;
        comm.content = content.isEmpty() ? comm.content : content;
        comm.updateTime = new Date();
        return commRepo.save(comm);
    }

    @GetMapping(path = "/{id}")
    public Communication getComm(@PathVariable(name = "id") Long id,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        Optional<Communication> byId = commRepo.findById(id);
        if (!byId.isPresent()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        Communication comm = byId.get();
        comm.pv++;
        return commRepo.save(comm);
    }

    @GetMapping(path = "/all")
    public List<Communication> getComms() {
        List<Communication> cs = new ArrayList<>();
        commRepo.findAll().forEach(cs::add);
        return cs;
    }

    @GetMapping(path = "/me")
    public List<Communication> getMyComm(HttpServletRequest request,
                                         HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {
            Long uid = CookieHelper.decodeCookie2UID(request.getCookies());
            List<Communication> allByUId = commRepo.findAllByUId(uid);
            return allByUId;
        }

    }

}
