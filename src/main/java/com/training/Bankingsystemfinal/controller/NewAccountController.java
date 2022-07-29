package com.training.Bankingsystemfinal.controller;


import com.training.Bankingsystemfinal.dto.NewAccountDTO;
import com.training.Bankingsystemfinal.service.NewAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewAccountController {
    @Autowired
    private NewAccountService newAccountService;

    @PostMapping("/openAccount")
    public ResponseEntity<Object>openUserAccount(@RequestBody NewAccountDTO newAccountDTO){
        System.out.println("In openAccountController......");
        return newAccountService.newAccount(newAccountDTO);
    }
}
