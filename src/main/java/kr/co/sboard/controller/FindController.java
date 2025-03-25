package kr.co.sboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FindController {

    @GetMapping("/find/changePassword")
    public String changePassword(){
        return "/find/changePassword";
    }

    @GetMapping("/find/password")
    public String password(){
        return "/find/password";
    }

    @GetMapping("/find/resultUserId")
    public String resultUserId(){
        return "/find/resultUserId";
    }

    @GetMapping("/find/userId")
    public String userId(){
        return "/find/userId";
    }



}
