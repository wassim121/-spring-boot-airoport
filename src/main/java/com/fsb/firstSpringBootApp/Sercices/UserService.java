package com.fsb.firstSpringBootApp.Sercices;

 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.firstSpringBootApp.Models.Reservation;
import com.fsb.firstSpringBootApp.Models.User;
import com.fsb.firstSpringBootApp.Repository.User_rep;
 
@Service
public class UserService  {

	 @Autowired
	    private User_rep userrep;

	    
	    public List < User > getAllUser() {
	        return userrep.findAll();
	    }

 	    public void saveUser(User user) {
	        this.userrep.save(user);
	    }
	    
 	    public User getUserById(long id) {
	        Optional < User > optional = userrep.findById(id);
	        User user = null;
	        if (optional.isPresent()) {
	            user = optional.get();
	        } else {
	            throw new RuntimeException(" user not found for id :: " + id);
	        }
	        return user;
	    }
	    
	    
 	      public void deleteUserById(long id) {
	       this.userrep.deleteById(id);
	      }
	      
	       
	      public User login(String email, String mdp) {
	    	  User user = userrep.findByemail(email);

	          if (user != null && user.getMdp().equals(mdp)) {
	              return user;
	          } else {
	              return null;
	          }
	      }
	      
	      public User exsite_user(String email) {
	    	  User user = userrep.findByemail(email);

	          if (user != null ) {
	              return user;
	          } else {
	              return null;
	          }
	      }
	      
	    
	    
}