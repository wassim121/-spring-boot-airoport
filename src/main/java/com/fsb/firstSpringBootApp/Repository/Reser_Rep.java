package com.fsb.firstSpringBootApp.Repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.Models.Reservation;

 @Repository
public interface Reser_Rep extends JpaRepository<Reservation,Long>{

}
