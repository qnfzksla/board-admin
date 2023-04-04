package com.qnfzksla.projectboardadmin.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/members")
@Controller /*** 어드민 회원 뷰*/
public class AdminUserAccountController {

    @GetMapping
    public String AdminUser(
            @PageableDefault(size = 10,sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable,
            Model model

            ){
        return "admin/members";
    }
}
