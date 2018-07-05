package top.letsgoduet.kaoyan.controller;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.Communication;
import top.letsgoduet.kaoyan.repo.CommunicationRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/comm")
public class CommunicationController {

    @Autowired
    private CommunicationRepo commRepo;

    @PostMapping(path = "")
    public Communication createComm(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam(name = "title") String title,
                                    @RequestParam(name = "content") String content) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {
            long uid = CookieHelper.decodeCookie2UID(request.getCookies());
            Communication comm = new Communication();
            comm.uId = uid;
            comm.title = title;
            comm.content = content;
            comm.createTime = comm.updateTime = System.currentTimeMillis();
            if (AdminUtil.isAdmin(uid)) {
                comm.level = Communication.LEVEL_HIGH;
            } else {
                comm.level = Communication.LEVEL_LOW;
            }
            return commRepo.save(comm);
        }
    }

    @PutMapping()
    public Communication updateComm(HttpServletRequest request,
                                    HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {

        }

        return null;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteComm(
            @PathVariable(name = "id") Long cid,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else {
            commRepo.deleteById(cid);
        }
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
