package com.fsb.firstSpringBootApp.Sercices;

 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.firstSpringBootApp.Models.Reservation;
import com.fsb.firstSpringBootApp.Repository.Reser_Rep;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ReservationService {
	@Autowired

	Reser_Rep rep;
	public void saveReservation(Reservation re) {
		this.rep.save(re);
	}
	
	
	public List<Reservation> listReservation() {
		return rep.findAll();
	}
	
	public void deleteReserById(long id) {
	       this.rep.deleteById(id);
	      }
	
	
	public Reservation getReservation(Long id) {
		 Optional < Reservation > optional = rep.findById(id);
		 Reservation Reservation = null;
	        if (optional.isPresent()) {
	        	Reservation = optional.get();
	        } else {
	            throw new RuntimeException(" Reservation not found for id :: " + id);
	        }
		 return Reservation;
	}
	
	  
}
