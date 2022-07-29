package com.training.Bankingsystemfinal.controller;


import com.training.Bankingsystemfinal.dto.ShowBalanceDTO;
import com.training.Bankingsystemfinal.service.ShowBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowBalanceController {
    @Autowired
    private ShowBalanceService showBalanceService;
    @GetMapping("/showBalance")
    public ResponseEntity<Object> showBalance(@RequestBody ShowBalanceDTO showBalanceDTO)
    {
        System.out.println("In Show Balance Controller......");
        return showBalanceService.showBalanceAmount(showBalanceDTO);
    }
}

