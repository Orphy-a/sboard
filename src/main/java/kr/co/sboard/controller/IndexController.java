package kr.co.sboard.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(Authentication auth) {


        if(auth != null && auth.isAuthenticated()){
            // 로그인을 성공 했을 때
            return "forward:/article/list";
        }

        return "/index";
    }

}
