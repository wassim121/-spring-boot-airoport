package com.fsb.firstSpringBootApp.Contrllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fsb.firstSpringBootApp.Models.Rec;
import com.fsb.firstSpringBootApp.Sercices.RecService;
 

@Controller
public class RecController {

	
	 @Autowired
		private RecService recService;

		@GetMapping("/ajouterRec")
		public String ajouterRec(Model model) {
			model.addAttribute("rec", new Rec());
			return "ajouterrec";
		}
		
	    

	    
		@PostMapping("/enregistrerRec")
		public String enregistrerRec(@ModelAttribute("rec") Rec rec) {
			recService.enregistrerRec(rec);
			return "redirect:/listRec";
		}

		@GetMapping("/listRec")
		public String listRec(Model model) {
			List<Rec> recs = recService.listRec();
			model.addAttribute("recs", recs);
			return "listRec";
		}
}

