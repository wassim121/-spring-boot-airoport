package com.fsb.firstSpringBootApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.Models.User;
 
@Repository
public interface User_rep extends JpaRepository<User, Long>{

 
 
     User findByemail(String email);

}