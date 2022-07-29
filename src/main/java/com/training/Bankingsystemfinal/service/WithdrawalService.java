package com.training.Bankingsystemfinal.service;


import com.training.Bankingsystemfinal.dto.WithdrawalDTO;
import com.training.Bankingsystemfinal.model.User;
import com.training.Bankingsystemfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> afterWithDrawalBalanceAmount(WithdrawalDTO withdrawalBalanceDTO){
        System.out.println("In Withdrawal Service");
        if(userRepository.existsByAccountNo(withdrawalBalanceDTO.getAccountNo())) {

            User user = userRepository.findUserByAccountNo(withdrawalBalanceDTO.getAccountNo());
            if (user.getBalance() >= withdrawalBalanceDTO.getAmount()) {
                int amount = user.getBalance() - withdrawalBalanceDTO.getAmount();
                user.setBalance(amount);
                userRepository.save(user);
                System.out.println("Updated Amount: " + user.getBalance());
                WithdrawalDTO newBalanceDTO = new WithdrawalDTO(user.getAccountNo(), user.getBalance());

                newBalanceDTO.setAmount(withdrawalBalanceDTO.getAmount());
                return new ResponseEntity(newBalanceDTO, HttpStatus.OK);
            }
            else{
                return new ResponseEntity("That much amount not exists", HttpStatus.BAD_REQUEST);
            }
        }
        else{
            return new ResponseEntity("User Not Exists", HttpStatus.BAD_REQUEST);
        }
    }
}
