package com.training.Bankingsystemfinal.controller;


import com.training.Bankingsystemfinal.dto.DepositDTO;
import com.training.Bankingsystemfinal.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    @PutMapping("/depositAmount")
    public ResponseEntity<Object> depositAmount(@RequestBody DepositDTO balanceDTO){
        System.out.println("In Deposit Amount Controller......");
        return depositService.afterDepositBalanceAmount(balanceDTO);
    }
}