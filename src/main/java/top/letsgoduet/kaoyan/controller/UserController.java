package top.letsgoduet.kaoyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.letsgoduet.kaoyan.model.User;
import top.letsgoduet.kaoyan.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping()
    public User createUser(@RequestParam(name = "uname") String uname,
                           @RequestParam(name = "pwd") String pwd,
                           @RequestParam(name = "phone") String phone) {
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
        return null;
    }

    @GetMapping
    public User getUser(@RequestParam Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @GetMapping(path = "/all")
    public List<User> getAllUser() {
        List<User> us = new ArrayList<>();
        userRepo.findAll().forEach(u -> {
            if (u.role != User.ROLE_MANAGER) {
                us.add(u);
            }
        });
        return us;
    }

}
