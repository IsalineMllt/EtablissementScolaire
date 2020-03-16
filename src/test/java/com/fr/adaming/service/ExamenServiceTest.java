package com.fr.adaming.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fr.adaming.entity.Classe;
import com.fr.adaming.entity.Examen;
import com.fr.adaming.entity.Matiere;
import com.fr.adaming.enumeration.Type;

@SpringBootTest
public class ExamenServiceTest {
	
	@Autowired
	private IExamenService service;
	
	// METHODE CREATION
	
	@Sql(statements = "delete from examen where date = '2020-05-21'", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void testCreatingValidExamen_shouldReturnExamenWithId () {
		
	Examen examenInput = new Examen();
	LocalDate date = LocalDate.parse("2020-05-21");
	examenInput.setCoef(2);
	examenInput.setDate(date);
	examenInput.setType(Type.CC);
	assertEquals(0, examenInput.getId());
				
	Examen returnedExamen = service.create(examenInput);
	assertNotEquals(0, returnedExamen.getId());
	
	}
			
		
}