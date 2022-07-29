package com.training.Bankingsystemfinal.service;


import com.training.Bankingsystemfinal.dto.NewAccountDTO;
import com.training.Bankingsystemfinal.model.User;
import com.training.Bankingsystemfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NewAccountService {
    Random rnd= new Random();
    
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<Object> newAccount(NewAccountDTO newAccountDTO){
        System.out.println("In New Account Service");
        String accountNo = String.valueOf(rnd.nextInt(1_000_000_000)+(rnd.nextInt(90)+10) *1_000_000_000L);
        System.out.println("generated account No. -" + accountNo);
        User newUser = new User(newAccountDTO.getFirstName(),newAccountDTO.getLastName(),newAccountDTO.getAddress(),
                newAccountDTO.getUsername(),newAccountDTO.getPassword(),accountNo,newAccountDTO.getBalance());

        if(!userRepository.existsByUsername(newUser.getUsername())) {
            userRepository.save(newUser);
            System.out.println("data save..");
//            NewAccountDTO accountDTO = new NewAccountDTO(newUser.getFirstName(), newUser.getLastName(), newUser.getAddress(),
//                    newUser.getUsername(), newUser.getPassword(), newUser.getAccountNo(), newUser.getBalance());

            return new ResponseEntity(newUser, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("User Name Already Exists",HttpStatus.BAD_REQUEST);
        }

    }
}
