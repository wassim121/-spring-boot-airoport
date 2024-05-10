package com.fsb.firstSpringBootApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.firstSpringBootApp.Models.Rec;

 
@Repository
public interface RecRepository extends JpaRepository<Rec, Long> {

}
