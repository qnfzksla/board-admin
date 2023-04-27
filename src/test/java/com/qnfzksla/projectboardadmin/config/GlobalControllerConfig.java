package com.qnfzksla.projectboardadmin.config;

import com.qnfzksla.projectboardadmin.service.VisitCountService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.mockito.BDDMockito.given;

@TestConfiguration
public class GlobalControllerConfig {

    @MockBean private VisitCountService visitCountService;

    @BeforeTestMethod
    public  void  securitySetup(){
        given(visitCountService.visitCount()).willReturn(0L);
    }
}
