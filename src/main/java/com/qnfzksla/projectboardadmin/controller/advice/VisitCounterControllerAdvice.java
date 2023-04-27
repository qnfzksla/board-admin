package com.qnfzksla.projectboardadmin.controller.advice;

import com.qnfzksla.projectboardadmin.service.VisitCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@ControllerAdvice
public class VisitCounterControllerAdvice {

    private final VisitCountService visitCountService;


    @ModelAttribute("visitCount")
    public  Long visitCount(){
        return visitCountService.visitCount();
    }
}
