package kr.co.sboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    @GetMapping("/article/list")
    public String list(){

        return "/article/list";
    }

    @GetMapping("/article/modify")
    public String modify(){

        return "/article/modify";
    }


    @GetMapping("/article/view")
    public String view(){

        return "/article/view";
    }

    @GetMapping("/article/write")
    public String write(){

        return "/article/write";
    }

}
