package com.training.Bankingsystemfinal.repository;


import com.training.Bankingsystemfinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);
    boolean existsByAccountNo(String accountNo);

     User findUserByAccountNo(String accountNo);
}
