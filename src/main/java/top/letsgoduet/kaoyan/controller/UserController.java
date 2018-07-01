package top.letsgoduet.kaoyan.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.CookieGenerator;
import top.letsgoduet.kaoyan.model.User;
import top.letsgoduet.kaoyan.repo.UserRepo;
import top.letsgoduet.kaoyan.utils.Encryptor;
import top.letsgoduet.kaoyan.utils.LoggerProvider;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    private static final int MAX_COOKIE_AGE = 24 * 60 * 60;
    private static final String SESSION_KEY = "SESSION_KEY";
    private static final Logger LOGGER = LoggerProvider.provideLogger(UserController.class);

    @PostMapping(path = "/login")
    public void login(HttpServletRequestWrapper request, HttpServletResponseWrapper response,
                      @RequestParam(name = "phone") String phone,
                      @RequestParam(name = "pwd") String pwd) {
        Encryptor.md5(pwd);
        User u = userRepo.findByPhone(phone);
        if (u == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else if (!u.pwd.equals(pwd)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            Cookie cookie = new Cookie(SESSION_KEY, u.id.toString());
            cookie.setMaxAge(MAX_COOKIE_AGE);
            response.addCookie(cookie);
            response.setStatus(HttpServletResponse.SC_OK);
        }
        Session session = new Session();

    }

    @PostMapping(path = "/logout")
    public void logout(HttpServletRequestWrapper request,
                       HttpServletResponseWrapper response) {
        HttpSession session = request.getSession();
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            session.removeAttribute(names.nextElement());
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping()
    public User createUser(@RequestParam(name = "uname") String uname,
                           @RequestParam(name = "pwd") String pwd,
                           @RequestParam(name = "phone") String phone) {
        LOGGER.info("post to create user");
        if (userRepo.findByPhone(phone) == null) {
            User u = new User();
            u.uname = uname;
            u.pwd = pwd;
            u.phone = phone;
            u = userRepo.save(u);
            return u;
        } else {
            return null;
        }
    }

    @PutMapping()
    public User updateUser() {
        LOGGER.info("update user info");
        return null;
    }

    @GetMapping
    public User getUser(@RequestParam Long id) {
        LOGGER.info("user's detail");
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @GetMapping(path = "/all")
    public List<User> getAllUser() {
        LOGGER.info("get all users");
        List<User> us = new ArrayList<>();
        userRepo.findAll().forEach(u -> {
            if (u.role != User.ROLE_MANAGER) {
                us.add(u);
            }
        });
        return us;
    }


}
