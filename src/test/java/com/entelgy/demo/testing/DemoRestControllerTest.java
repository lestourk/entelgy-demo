package com.entelgy.demo.testing;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.entelgy.demo.controller.DemoController;
import com.entelgy.demo.dto.RequestDto;
import com.entelgy.demo.service.DemoService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(value = DemoController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class DemoRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DemoService service;

	@BeforeAll
	public static void setUp() throws Exception {

	}

	@Test
	public void whenListarConArgs_thenReturnJsonArray() throws Exception {

		RequestDto in = new RequestDto(20, 149, 2674);
		mvc.perform(MockMvcRequestBuilders.post("/entelgy/commentsConArgs").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(in)))
		        .andExpect(status().isOk());
	}
	
	@Test
	public void whenListarSinArgs_thenReturnJsonArray() throws Exception {

		mvc.perform(MockMvcRequestBuilders.post("/entelgy/commentsSinArgs").contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk());
		verify(service, VerificationModeFactory.times(1)).listarComentarios();
		reset(service);
	}

	
}