package com.valtech.security.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SprsectestApplicationTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	@WithAnonymousUser
	void testHelloPageWithAnonymous()throws Exception {
		mvc.perform(get("/hello")).andDo(print()).andExpect(content().string("Hello")).andExpect(status().isOk());
	}
	
	@Test
	@WithAnonymousUser
	void testUserPageWithAnonymousShouldReturnUnauthorised()throws Exception {
		mvc.perform(get("/user")).andDo(print()).andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithMockUser(roles="USER")
	void testUserPageWithUser()throws Exception	{
		mvc.perform(get("/user")).andDo(print()).andExpect(content().string("Hello User")).andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="USER")
	void testAdminPageWithUserShouldReturnUnAuthorized()throws Exception	{
		mvc.perform(get("/admin")).andDo(print()).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles="ADMIN")
	void testAdminPageWithAdmin()throws Exception	{
		mvc.perform(get("/admin")).andDo(print()).andExpect(content().string("Hello Admin")).andExpect(status().isOk());
	}
}








