package com.fsb.firstSpringBootApp.Contrllers;

 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.fsb.firstSpringBootApp.Models.Reservation;
import com.fsb.firstSpringBootApp.Models.Vol;
import com.fsb.firstSpringBootApp.Sercices.ReservationService;
import com.fsb.firstSpringBootApp.Sercices.VolService;
 
 
@Controller
public class Reservation_Ctrl {
	 @Autowired
	private ReservationService ser;

	 @Autowired
		private VolService volser;

		 
	  
		@GetMapping("/ajouterRes")
		public String ajouterRes(Model model) {
			model.addAttribute("res", new Reservation());
			return "Ajouter_REservation";
		}
		
	    

	    
		@PostMapping("/enregistrerRes")
		public String enregistrerRes(@ModelAttribute("res") Reservation res) {
			
			
			if(volser.getVol(res.getIdvol()) !=null) {
			ser.saveReservation(res);
			return "redirect:/listRes";
			}
			else {
				return "redirect:/ajouterRes";
			}
			
		}

		@GetMapping("/listRes")
		public String listRes(Model model) {
			List<Reservation> ress = ser.listReservation();
			model.addAttribute("ress", ress);
			return "Liste_Reservation";
		}
		
		@GetMapping("/deleteres/{id}")
	    public String deleteres(@PathVariable (value = "id") long id) {
 			ser.deleteReserById(id);

	     return "redirect:/listRes";
	    }
	
		 
		
		@GetMapping("/Update_Res/{id}")
		public String update(@PathVariable ( value = "id") long id, Model model) {
		     Reservation res = ser.getReservation(id);

		     model.addAttribute("res", res);
	 		ser.deleteReserById(id);

		     return "update_reservation";
			
		}
		 
		
		
		 
		
		
		 
		
}
