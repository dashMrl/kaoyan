package top.letsgoduet.kaoyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.letsgoduet.kaoyan.model.User;

@RestController
public class HelloController {
    @RequestMapping(method = {RequestMethod.GET},path = "/hello")
    public User getHello(){
        return null;
    }
}
