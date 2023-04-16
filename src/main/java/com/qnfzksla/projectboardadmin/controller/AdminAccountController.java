package com.qnfzksla.projectboardadmin.controller;

import com.qnfzksla.projectboardadmin.domain.AdminAccount;
import com.qnfzksla.projectboardadmin.dto.response.AdminAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/members")
@Controller /*** 어드민 회원 뷰*/
public class AdminAccountController {

    @GetMapping
    public String AdminUser(Model model){
        return "admin/members";
    }
    @ResponseBody
    @GetMapping("/api/admin/members")
    public List<AdminAccountResponse> getMembers(){
        return List.of();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @DeleteMapping("/api/admin/members/{userId}")
    public void delete(@PathVariable String userId){

    }

}
