package com.qnfzksla.projectboardadmin.config;

import com.qnfzksla.projectboardadmin.domain.constant.RoleType;
import com.qnfzksla.projectboardadmin.dto.AdminAccountDto;
import com.qnfzksla.projectboardadmin.service.AdminAccountService;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;
import java.util.Set;


import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;

@Import(SecurityConfig.class)
@TestConfiguration

public class SecurityConfigTest {

    @MockBean
    private AdminAccountService adminAccountService;

    @BeforeTestMethod
    public void securitySetup(){
        BDDMockito.given(adminAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createAdminAccountDto()));
        BDDMockito.given(adminAccountService.saveUser(anyString(),anyString(),anySet(),anyString(),anyString(),anyString()))
                .willReturn(createAdminAccountDto());

    }

    private AdminAccountDto createAdminAccountDto(){
        return AdminAccountDto.of(
                "unoTest",
                "pw",
                Set.of(RoleType.USER),
                "uno-test@email.com",
                "uno-test",
                "test memo"
        );
    }



}