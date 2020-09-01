package com.rithika.util.ListUtil;

import static 
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rithika.util.ListUtil.controllers.ListController;
import com.rithika.util.ListUtil.services.ListService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ListController.class)

@AutoConfigureMockMvc
public class WebLayerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ListService listService;
   
	 @Before
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }
	
	@Test
	public void testIfLogin() throws Exception {
		 try {
			  this.mockMvc.perform(get("/login"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("login"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
