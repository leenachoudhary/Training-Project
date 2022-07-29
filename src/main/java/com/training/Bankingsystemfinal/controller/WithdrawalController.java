package com.training.Bankingsystemfinal.controller;

import com.training.Bankingsystemfinal.dto.WithdrawalDTO;
import com.training.Bankingsystemfinal.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawalController {

    @Autowired
    private
    WithdrawalService withdrawalService;

    @PutMapping("/withdrawalAmount")
    public ResponseEntity<Object> withdrawalAmount(@RequestBody WithdrawalDTO withdrawalBalanceDTO){
        System.out.println("In Deposit Amount Controller......");
        return withdrawalService.afterWithDrawalBalanceAmount(withdrawalBalanceDTO);
    }
}
