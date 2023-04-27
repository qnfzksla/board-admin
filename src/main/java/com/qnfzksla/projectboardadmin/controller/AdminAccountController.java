package com.qnfzksla.projectboardadmin.controller;

import com.qnfzksla.projectboardadmin.domain.AdminAccount;
import com.qnfzksla.projectboardadmin.dto.response.AdminAccountResponse;
import com.qnfzksla.projectboardadmin.service.AdminAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Controller /*** 어드민 회원 뷰*/
public class AdminAccountController {

    private final AdminAccountService adminAccountService;

    @GetMapping("/admin/members")
    public String members(){

        return "admin/members";
    }
    @ResponseBody
    @GetMapping("/api/admin/members")
    public List<AdminAccountResponse> getMembers(){

        return adminAccountService.users().stream()
                .map(AdminAccountResponse::from)
                .toList();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @DeleteMapping("/api/admin/members/{userId}")
    public void delete(@PathVariable String userId){
        adminAccountService.deleteUser(userId);

    }

}
