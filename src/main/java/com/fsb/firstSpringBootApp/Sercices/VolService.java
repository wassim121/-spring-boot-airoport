package com.fsb.firstSpringBootApp.Sercices;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.fsb.firstSpringBootApp.Models.Vol;
import com.fsb.firstSpringBootApp.Repository.VolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VolService {

	@Autowired
	private VolRepository volRepository;

	public void enregistrerVol(Vol vol) {
		this.volRepository.save(vol);
	}

	public List<Vol> listVols() {
		return volRepository.findAll();
	}

	public Vol getVol(Long id) {
		 Optional < Vol > optional = volRepository.findById(id);
		 Vol Vol = null;
	        if (optional.isPresent()) {
	        	Vol = optional.get();
	        } else {
	        	return null;
	        }
		 return Vol;
	}
	 
	 
	public List<Vol> getVolSelected( String lieuArriver) {
		List<Vol> optional = volRepository.findBylieuArriver(lieuArriver);
		  
		 return optional;
	}
 
	public List<Vol> getVolSelectedby_lieuArriver_date(String lieuArriver, String lieuDepart) {
	    List<Vol> liste1 = volRepository.findBylieuArriver(lieuArriver);
	    List<Vol> liste2 = volRepository.findBylieuDepart(lieuDepart);
	    List<Vol> liste = new ArrayList<>();

	    for(Vol v:liste1) {
	    	if(liste2.contains(v))
	    		liste.add(v);
	    }
	    
	    return liste;
	}

	 
}

