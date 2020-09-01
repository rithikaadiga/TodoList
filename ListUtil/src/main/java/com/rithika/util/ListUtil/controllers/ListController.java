package com.rithika.util.ListUtil.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rithika.util.ListUtil.beans.ListDetails;
import com.rithika.util.ListUtil.beans.ListOfListDetails;
import com.rithika.util.ListUtil.beans.UserLogin;
import com.rithika.util.ListUtil.services.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;
	
	
	
	@GetMapping("/login")
	  public String getUserLogin(Model model) {
	    model.addAttribute("login", new UserLogin());
	    return "login";
	  }
	
	@GetMapping("/logout")
	  public String getUserLogout(Model model) {
	    model.addAttribute("login", new UserLogin());
	    return "login";
	  }

	  @PostMapping("/login")
	  public String postUserLogin(@ModelAttribute UserLogin userLogin, Model model, RedirectAttributes redirectAttributes) {
	    String isValid = listService.validateUser(userLogin); 
	    if(isValid.equals("Empty")) {
	    	redirectAttributes.addFlashAttribute("errorMessage", "Please Enter Login Details.");
	        return "redirect:/login";
	    }
	    if(isValid.equals("Incorrect")) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Incorrect Login Details. Please Try Again.");
	        return "redirect:/login";
	    }
		model.addAttribute("login", userLogin);
	    listService.getUserTasks(model);
	    return "display";
	  }

	  
	  @PostMapping("/saveStatus")
	  public String postTaskStatus(@ModelAttribute ListOfListDetails aListOfListDetails, Model model) {
	  listService.updateTaskStatus(aListOfListDetails.getaList());
	  aListOfListDetails.setMessage("Successfully saved!");
	  model.addAttribute("displaydata", aListOfListDetails);
      return "display";
	  }
	  
	  
	  @GetMapping("/addpage")
	  public String add(@ModelAttribute ListOfListDetails aListOfListDetails, Model model) {
		  model.addAttribute("myNewTask", new ListDetails());
		  return "addpage";
	  }
	  
	  @GetMapping("/deletepage")
	  public String delete(@ModelAttribute ListOfListDetails aListOfListDetails, Model model) {
		  model.addAttribute("displaydata", aListOfListDetails);
		  return "deletepage";
	  }

	  @PostMapping("/add")
	  public String postAddNewTask(@ModelAttribute ListDetails listDetails, Model model, RedirectAttributes redirectAttributes) {
	    String isValid = listService.validateNewTask(listDetails); 
	    if(isValid.equals("Empty")) {
	    	listDetails.setMessage("Please Enter Task Name.");
		    model.addAttribute("myNewTask", listDetails);
	    	return "addpage";
	    }
	   
		
	    listService.addNewTask(listDetails);
	    listDetails.setMessage("Successfully added New Task.");
	    model.addAttribute("myNewTask", listDetails);
        return "addpage";
	  }
	  
	  @PostMapping("/deletetasks")
	  @Transactional
	  public String postDeleteTasks(@ModelAttribute ListOfListDetails aListOfListDetails, Model model, RedirectAttributes redirectAttributes) {
	  if(!listService.validateDelete(aListOfListDetails.getaList())) {
		  aListOfListDetails.setMessage("Task Id does not exist.");
		  model.addAttribute("displaydata", aListOfListDetails);
	      return "deletepage";
	  }
	  listService.performDelete(aListOfListDetails.getaList());
	  aListOfListDetails.setMessage("Deletion Successful");
	  model.addAttribute("displaydata", aListOfListDetails);
	  return "deletepage";
	  }
	  

}
