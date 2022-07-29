package com.training.Bankingsystemfinal.service;


import com.training.Bankingsystemfinal.dto.DepositDTO;
import com.training.Bankingsystemfinal.model.User;
import com.training.Bankingsystemfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object>afterDepositBalanceAmount(DepositDTO balanceDTO){
        System.out.println("In Deposit Service");
        if(userRepository.existsByAccountNo(balanceDTO.getAccountNo())){

            User user =userRepository.findUserByAccountNo(balanceDTO.getAccountNo());
            int amount= user.getBalance()+ balanceDTO.getAmount();
            user.setBalance(amount);
            userRepository.save(user);
            System.out.println("Updated Amount: " + user.getBalance());
            DepositDTO newBalanceDTO = new DepositDTO(user.getAccountNo(), user.getBalance());
            newBalanceDTO.setAmount(balanceDTO.getAmount());
            return new ResponseEntity(newBalanceDTO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("User Not Exists", HttpStatus.BAD_REQUEST);
        }
    }

}
