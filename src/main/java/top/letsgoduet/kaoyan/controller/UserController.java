package top.letsgoduet.kaoyan.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.User;
import top.letsgoduet.kaoyan.repo.UserRepo;
import top.letsgoduet.kaoyan.utils.AdminUtil;
import top.letsgoduet.kaoyan.utils.CookieHelper;
import top.letsgoduet.kaoyan.utils.Encryptor;
import top.letsgoduet.kaoyan.utils.LoggerProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    private static final Logger LOGGER = LoggerProvider.provideLogger(UserController.class);

    @PostMapping(path = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam(name = "phone") String phone,
                      @RequestParam(name = "pwd") String pwd) {
        pwd = Encryptor.md5(pwd);
        User u = userRepo.findByPhone(phone);
        if (u == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else if (!u.pwd.equals(pwd)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            response.addCookie(CookieHelper.createCookie(u));
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @PostMapping(path = "/logout")
    public void logout(HttpServletRequest request,
                       HttpServletResponseWrapper response) {
        HttpSession session = request.getSession();
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            session.removeAttribute(names.nextElement());
        }
        response.addCookie(null);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping()
    public User createUser(
            @RequestParam(name = "uname") String uname,
            @RequestParam(name = "pwd") String pwd,
            @RequestParam(name = "phone") String phone,
            HttpServletResponse response) {
        LOGGER.info("post to create user");
        if (userRepo.findByPhone(phone) == null) {
            User u = new User();
            u.uname = uname;
            u.pwd = Encryptor.md5(pwd);
            u.phone = phone;
            u = userRepo.save(u);
            response.addCookie(CookieHelper.createCookie(u));
            return u;
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @PutMapping()
    public User updateUser() {
        LOGGER.info("update user info");
        return null;
    }

    @GetMapping(path = "/{id}")
    public User getUser(HttpServletResponse response,
                        @PathVariable(name = "id") Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (!optionalUser.isPresent()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } else {
            User u = optionalUser.orElse(null);
            u.pwd = null;
            return u;
        }
    }

    @GetMapping(path = "/all")
    public List<User> getAllUser(
            HttpServletRequest request,
            HttpServletResponseWrapper response) {
        if (!CookieHelper.isCookieValid(request.getCookies())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        if (!AdminUtil.isAdmin(CookieHelper.decodeCookie2UID(request.getCookies()))) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        List<User> us = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            user.pwd = null;
            if (user.role != User.ROLE_MANAGER) {
                us.add(user);
            }
        });
        return us;

    }


}
