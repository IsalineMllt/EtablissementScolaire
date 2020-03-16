package com.fr.adaming.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.adaming.dto.AbsenceCreateDto;
import com.fr.adaming.dto.ClasseCreateDto;
import com.fr.adaming.dto.EtudiantCreateDto;
import com.fr.adaming.dto.ResponseDto;
import com.fr.adaming.enumeration.Sexe;

@SpringBootTest
@AutoConfigureMockMvc
public class AbsenceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper mapper = new ObjectMapper();
	
	@Sql(statements = "insert into etudiant (id, cni, email, cp, num) values(1, '00' ,'email1@email.com', 69800, 0631313131)", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "delete from Absence", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Sql(statements = "delete from Etudiant", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void testCreatingAbsenceWithController_shouldWork() throws Exception {

		AbsenceCreateDto dtoRequest = new AbsenceCreateDto();
		String date = "2019-03-23";
		dtoRequest.setDateStart(date);
		dtoRequest.setDateEnd(date);
		dtoRequest.setJustif("justif");
		dtoRequest.setDescript("descript");
		dtoRequest.setId_etudiant(1);
		
		String dtoAsJson = mapper.writeValueAsString(dtoRequest);
		
		String responseAsString = mockMvc
			.perform(post("/absence").contentType(MediaType.APPLICATION_JSON_VALUE).content(dtoAsJson))
			.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		ResponseDto dtoResponse = mapper.readValue(responseAsString, ResponseDto.class);
		
		assertThat(dtoResponse).isNotNull();
		assertThat(dtoResponse).hasFieldOrPropertyWithValue("message", "SUCCESS");
		assertThat(dtoResponse).hasFieldOrPropertyWithValue("body", dtoResponse.getBody());
		assertThat(dtoResponse).hasFieldOrPropertyWithValue("isError", false);
	}
	
	@Test
	@Sql(statements = "delete from Absence", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void testCreatingBadAbsenceWithController_shouldNotWork() throws Exception {

		String responseAsString = mockMvc
			.perform(post("/absence").contentType(MediaType.APPLICATION_JSON_VALUE).content("{'date_debut':}"))
			.andExpect(status().isBadRequest()).andReturn().getResponse().getContentAsString();

		assertThat(responseAsString).isEmpty();
	}

}
