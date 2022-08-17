package com.rama.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rama.controller.WelcomeController;
import com.rama.service.WelcomeService;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

	// mock object for your dependent
	@MockBean
	private WelcomeService welcomeService;

	//it is used send request for our controller
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcomeMsg() throws Exception {
		
		//set method behavior
		when(welcomeService.getMessage()).thenReturn("Hello Good Morning");

		//prepare request or create request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

		
		ResultActions perform = mockMvc.perform(requestBuilder);

		MvcResult result = perform.andReturn();

		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);

	}

}
