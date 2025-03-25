package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.config.AppInfo;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final TermsService termsService;
    private final UserService userService;

    private final AppInfo appInfo;

    @GetMapping("/user/info")
    public String info(){
        return "/user/info";
    }

    @GetMapping("/user/login")
    public String login(){



        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){

        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(HttpServletRequest req, UserDTO userDTO){

        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        // 서비스 호출
        userService.register(userDTO);

        return "redirect:/user/login";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = termsService.terms();

        model.addAttribute("termsDTO", termsDTO);

        return "/user/terms";
    }

    @GetMapping("/user/{type}/{value}")
    public ResponseEntity<Map<String, Long>> user(@PathVariable("type") String type, @PathVariable("value") String value){

        log.info("type : " + type);
        log.info("value : " + value);

        // 서비스 호출
        long count = userService.checkUser(type, value);


        // JSON 생성
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("count", count);



        return ResponseEntity.ok().body(resultMap);

    }


}
