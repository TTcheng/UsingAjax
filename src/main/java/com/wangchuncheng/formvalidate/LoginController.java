package com.wangchuncheng.formvalidate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Wangchuncheng on 2018/7/20 10:55
 */
@Controller
@RequestMapping("/formvalidate")
public class LoginController {
    List<String> usedNames = Arrays.asList("aaa", "bbb", "ccc", "Jack", "Tom");

    @RequestMapping(value = "/validateUsername", method = RequestMethod.POST)
    public String usernameValidate(@RequestParam String username) {
        System.out.println("LoginController.usernameValidate");
//        ModelAndView availableMv = new ModelAndView("/formvalidate/username_available.jsp");
//        ModelAndView unavailableMv = new ModelAndView("/formvalidate/username_unavailable.jsp");
        if (usedNames.contains(username)) {
//            classpath:/formvalidate/username_unavailable.jsp
            return "username_unavailable";
        } else {
//            classpath:/formvalidate/username_available.jsp
            return "username_available";
        }
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("LoginController.index");
        // classpath:/formvalidate/index.jsp
        return "index";
    }
}
