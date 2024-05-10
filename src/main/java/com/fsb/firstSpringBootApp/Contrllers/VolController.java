package com.fsb.firstSpringBootApp.Contrllers;
 

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsb.firstSpringBootApp.Models.Reservation;
import com.fsb.firstSpringBootApp.Models.Vol;
import com.fsb.firstSpringBootApp.Repository.VolRepository;
import com.fsb.firstSpringBootApp.Sercices.VolService;

import org.springframework.ui.Model;
 
 
@Controller
public class VolController {

	 @Autowired
		private VolService volService;

	 @Autowired
	    private VolRepository volRepository;
	 
		@GetMapping("/ajouterVol")
		public String ajouterVol(Model model) {
			model.addAttribute("vol", new Vol());
			return "Ajouter_Vol";
		}
		
	    
		
		@PostMapping("/enregistrerVol")
		public String enregistrerVol(@ModelAttribute("vol") Vol vol) {
			volService.enregistrerVol(vol);
			return "redirect:/listv";
		}

		@GetMapping("/listv")
		public String listVol(Model model) {
			List<Vol> vols = volService.listVols();
			model.addAttribute("vols", vols);
			return "Liste_Vol";
		}

	    
	  
		@GetMapping("/ajouterRes/{id}")
		public String ajouterRes(@PathVariable ( value = "id") long id,Model model) {
			Vol vol=volService.getVol(id);
			if(vol.getNbP()!=0) {
			model.addAttribute("res", new Reservation());
			return "Ajouter_REservation";
			}
			else {
			
				
				return "redirect:/listv";
			}
			
		}
		
		
		 @GetMapping("/selectedVols")
		    public String selectedVols() {
		        return "vol_select";
		    }
		 @PostMapping("/selectedVols")
		    public String selectedVols( @RequestParam String lieuArriver,Model model) {
		        
		       
				List<Vol> volselected = volService.getVolSelected(lieuArriver);
		        
		        model.addAttribute("volselected", volselected);
		        
		        return "vol_select";
		    }
		 
		 @GetMapping("/selectedVolsbydepart_lieu")
		    public String selectedVolsbydepart_lieu() {
		        return "selectedVolsbydate_lieu";
		    }
		 @PostMapping("/selectedVolsbydepart_lieu")
		    public String selectedVolsbydepart_lieu( @RequestParam String lieuArriver,@RequestParam   String lieuDepart,Model model) {
		        
		       
				List<Vol> volselectedbydepart_lieu = volService.getVolSelectedby_lieuArriver_date(lieuArriver,lieuDepart);
		        
		        model.addAttribute("volselectedbydepart_lieu", volselectedbydepart_lieu);
		        System.out.print(volselectedbydepart_lieu.toString());
		        return "selectedVolsbydate_lieu";
		    }

}
