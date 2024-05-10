package com.fsb.firstSpringBootApp.Sercices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.firstSpringBootApp.Models.Rec;
import com.fsb.firstSpringBootApp.Repository.RecRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecService {

	
	@Autowired
	private RecRepository recRepository;

	public void enregistrerRec(Rec rec) {
		this.recRepository.save(rec);
	}

	public List<Rec> listRec() {
		return recRepository.findAll();
	}
}

