package com.fr.adaming.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AbsenceCreateDto {
	
	@NotNull
	private String dateStart;
	
	private String dateEnd;
	
	private String justif;
	
	private String descript;
	
	private int id_etudiant;


}
