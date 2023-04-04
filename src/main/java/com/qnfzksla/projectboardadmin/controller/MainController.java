package com.qnfzksla.projectboardadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller /*** 메인 루트 뷰*/
public class MainController {

    @GetMapping("/")
    public String root(){
        return "forward:/management/articles";
    }

}
