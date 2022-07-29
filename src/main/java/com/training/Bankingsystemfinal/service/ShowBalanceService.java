package com.training.Bankingsystemfinal.service;

import com.training.Bankingsystemfinal.dto.ShowBalanceDTO;
import com.training.Bankingsystemfinal.model.User;
import com.training.Bankingsystemfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShowBalanceService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> showBalanceAmount(ShowBalanceDTO showBalanceDTO) {
        System.out.println("In Show Balance Service");
        if (userRepository.existsByAccountNo(showBalanceDTO.getAccountNo())) {
            User user = userRepository.findUserByAccountNo(showBalanceDTO.getAccountNo());
            int amount = user.getBalance();
            ShowBalanceDTO newShowBalanceDTO = new ShowBalanceDTO(user.getAccountNo());
            newShowBalanceDTO.setBalance(amount);
            return new ResponseEntity(newShowBalanceDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity("User Not Exists", HttpStatus.BAD_REQUEST);
        }

    }

}

