package com.canon.controller;

import com.canon.base.common.ServiceContext;
import com.canon.base.common.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:21
 * @Description:
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public Serializable helloWorld() {
        return "hello world";
    }

    @GetMapping("/index")
    public ModelAndView getIndex(ModelAndView modelAndView) {
        UserContext currentUser = ServiceContext.getCurrentUser();
        currentUser = new UserContext();
        currentUser.setUserName("阳光帅气小凡凡");
        modelAndView.addObject("userName", "28 IT man");
        modelAndView.setViewName("index");
        Map<String, Object> model = modelAndView.getModel();
        model.put("nickName", "ni da ye");
        modelAndView.addAllObjects(model);
        return modelAndView;
    }

    @GetMapping("doindex")
    public String doIndex(Model model) {
        UserContext currentUser = ServiceContext.getCurrentUser();
        currentUser = new UserContext();
        currentUser.setUserName("阳光帅气小凡凡");
        model.addAttribute("user", currentUser);
        model.addAttribute("userName", "woca");
        model.addAttribute("nickName", "nima");
        return "index";
    }

}
