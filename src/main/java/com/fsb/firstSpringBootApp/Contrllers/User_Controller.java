package com.fsb.firstSpringBootApp.Contrllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsb.firstSpringBootApp.Models.User;
import com.fsb.firstSpringBootApp.Sercices.UserService;
 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
 

@Controller
public class User_Controller {

    @Autowired
    private UserService userervice;

     
    @GetMapping("/listeuser")
    public String viewHomePage(Model model) {
        model.addAttribute("listeusers", userervice.getAllUser());
        return "Liste_User";
    }
    
    @GetMapping("/saveUser")
    public String saveUser(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "Ajouter_User";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(Model model,@ModelAttribute("user") User user) {
        // save employee to database
    	User us=userervice.exsite_user(user.getEmail());
    	if(us==null) {
    		userervice.saveUser(user);
        return "redirect:/login";
    	}
    	else {
    		String existe="il existe user";
    		model.addAttribute("existe",existe);
    		return "redirect:/saveUser";
    	}
        
    }
    
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
     User user = userervice.getUserById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("user", user);
     return "Update_User";
    }
    
    
    
    
    
    
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {
     
     // call delete employee method 
     this.userervice.deleteUserById(id);
     return "redirect:/login";
    }
    


    
    
    @GetMapping("/home")
    public String showhome() {
        return "index";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String mdp, HttpSession session ,Model model) {
    	User user = userervice.login(email, mdp);
    	if (user != null) {
    	session.setAttribute("loggedInuser", user);
        model.addAttribute("username", user.getFirstName());

    	return "redirect:/home";
    	} else {
    	return "redirect:/login";
    	}
    	
    	
    	
    	
    	}
    
    
    
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

    
    
}