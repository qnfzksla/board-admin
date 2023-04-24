package com.qnfzksla.projectboardadmin.controller;

import com.qnfzksla.projectboardadmin.dto.response.UserAccountResponse;
import com.qnfzksla.projectboardadmin.service.UserAccountManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/management/user-accounts")
@Controller /**회원 관리 뷰*/
public class UserAccountManagementController {

    private final UserAccountManagementService userAccountManagementService;

    @GetMapping
    public String userAccounts( Model model){
        model.addAttribute(
                "userAccounts",
                userAccountManagementService.getUserAccounts().stream().map(UserAccountResponse::from).toList()
        );

        return "management/user-accounts";
    }

    @ResponseBody
    @GetMapping("/{userId}")
    public UserAccountResponse userAccount(@PathVariable String userId) {
        return UserAccountResponse.from(userAccountManagementService.getUserAccount(userId));
    }

    @PostMapping("/{userId}")
    public String deleteArticleComment(@PathVariable String userId) {
        userAccountManagementService.deleteUserAccount(userId);

        return "redirect:/management/user-accounts";
    }
}
