package com.canon.controller;

import com.canon.base.common.ServiceContext;
import com.canon.base.common.UserContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:21
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Serializable helloWorld() {
        return "hello world";
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        UserContext currentUser = ServiceContext.getCurrentUser();
        currentUser = new UserContext();
        currentUser.setUserName("阳光帅气小凡凡");
        model.addAttribute("user", currentUser);
        return "index";
    }
}
