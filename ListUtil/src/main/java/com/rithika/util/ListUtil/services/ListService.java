package com.rithika.util.ListUtil.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rithika.util.ListUtil.beans.ListDetails;
import com.rithika.util.ListUtil.beans.ListOfListDetails;
import com.rithika.util.ListUtil.beans.UserLogin;
import com.rithika.util.ListUtil.entities.ListEntities;
import com.rithika.util.ListUtil.entities.UserEntities;
import com.rithika.util.ListUtil.repositories.ListRepository;
import com.rithika.util.ListUtil.repositories.UserRepository;

@Service
public class ListService {
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	private String userName;
	
	public void getUserTasks(Model model) {
		UserLogin userLogin = (UserLogin)model.getAttribute("login");
	    List<ListEntities> it = listRepository.findByUserName(userLogin.getUserName());
	    ListOfListDetails aListOfListDetails = new ListOfListDetails();
	    List<ListDetails> aList = new ArrayList<ListDetails>();
	    it.forEach(e -> {
	    	ListDetails aListDetails = new ListDetails();
	    	aListDetails.setTaskId(e.getTaskId());
	    	aListDetails.setTaskName(e.getTaskName());
	    	aListDetails.setStatus(e.getStatus());
	    	aListDetails.setTaskDesc(e.getTaskDesc());
	    	aListDetails.setUserName(e.getUserName());
	    	aList.add(aListDetails);
	    });
	    		
	    aListOfListDetails.setaList(aList);
	    model.addAttribute("displaydata", aListOfListDetails);
	}

	public String validateUser(UserLogin userLogin) {
		if(userLogin.getUserName().isEmpty() || userLogin.getPassword().isEmpty()) {
			return "Empty";
		}
		Optional<UserEntities> userEntity = userRepository.findById(userLogin.getUserName());
		if(userEntity == null || !userEntity.isPresent()) {
			return "Incorrect";
		} else if(!userEntity.get().getPassword().equals(userLogin.getPassword())) {
			return "Incorrect";
		}
		userName = userLogin.getUserName();
		return "Success";
	}
	
	public void updateTaskStatus(List<ListDetails> getaList) {
		getaList.forEach(e -> {  
			ListEntities listEntities = new ListEntities();
			listEntities.setStatus(e.getStatus());
			listEntities.setTaskDesc(e.getTaskDesc());
			listEntities.setTaskId(e.getTaskId());
			listEntities.setTaskName(e.getTaskName());
			listEntities.setUserName(e.getUserName());
			listEntities.setLastUpdateTs(new Timestamp(System.currentTimeMillis()));
			listRepository.save(listEntities);
		});
		//error handling
	}

	public String validateNewTask(ListDetails listDetails) {
		if(listDetails.getTaskName().isEmpty()) {
			return "Empty";
		}
		return "Valid";
	}

	public void addNewTask(ListDetails e) {
		ListEntities listEntities = new ListEntities();
		listEntities.setStatus(false); 
		listEntities.setTaskDesc(e.getTaskDesc());
		/* listEntities.setTaskId(e.getTaskId()); */
		listEntities.setTaskName(e.getTaskName());
		listEntities.setUserName(userName);
		listEntities.setLastUpdateTs(new Timestamp(System.currentTimeMillis()));
		listRepository.save(listEntities);
	}

	public void performDelete(List<ListDetails> listOfListDetails) {
		
		for(ListDetails details: listOfListDetails) {
			if(details.getDeleteStatus()) {
				listRepository.deleteByTaskId(details.getTaskId());
			}
		}
		 
	}

	public Boolean validateDelete(List<ListDetails> listOfListDetails) {
		boolean ind = false;
		for(ListDetails details: listOfListDetails) {
			if(details.getDeleteStatus() && !listRepository.existsByTaskId(details.getTaskId())) {
				ind = true;
				break;
			}
		}
		return !ind;
	}

}

