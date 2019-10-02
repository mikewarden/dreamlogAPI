package com.mw.DreamLogAPI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mw.DreamLogAPI.model.Dream;
import com.mw.DreamLogAPI.repository.DreamRepository;

import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = DreamLogApiApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration.properties")



public class DreamLogIntegrationTest {

	@Autowired
	private DreamRepository dreamRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private Dream testDream;
	
	@Before 
	public void setUp() {
		testDream = new Dream("testDream", "testing 123", "today", true, false,
			false, false, false);
		dreamRepository.save(testDream);
	}
	
	@After
	public void tearDown() {
		dreamRepository.delete(testDream);
	}
	
	@Test
	public void givenDream_getDream_returnDream() throws Exception {
		Long dreamId = testDream.getId();
		mvc.perform(get("/dream" + dreamId).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.title", is("testDream")));
	}
	
	@Test
	public void findAll_returnAllDreams() throws Exception {
		mvc.perform(get("/dreams").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].title", is("testDream")));
	}


}