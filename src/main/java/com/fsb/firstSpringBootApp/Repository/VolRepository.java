package com.fsb.firstSpringBootApp.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.Models.Vol;

 
@Repository
public interface VolRepository extends JpaRepository<Vol, Long> {

	List<Vol> findBylieuArriver( String lieuArriver);
	List<Vol> findBylieuDepart( String lieuDepart);

}

