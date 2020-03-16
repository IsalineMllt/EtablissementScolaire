package com.fr.adaming.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fr.adaming.dto.ClasseCreateDto;
import com.fr.adaming.dto.ExamenCreateDto;
import com.fr.adaming.dto.ExamenUpdateDto;
import com.fr.adaming.entity.Examen;
import com.fr.adaming.entity.Matiere;
import com.fr.adaming.service.IMatiereService;
import com.fr.adaming.service.MatiereService;

public class ExamenConverter implements IConverter<ExamenCreateDto, ExamenUpdateDto, Examen> {

	@Autowired
	private IMatiereService serviceMat;
	
	@Override
	public Examen convertCreateDtoToEntity(ExamenCreateDto createDto) {
		Examen exam = new Examen();
		exam.setCoef(createDto.getCoefExamen());
		exam.setDate(createDto.getDateExamen());
		Matiere mat =serviceMat.readByNom(createDto.getMatiereExamen());
		exam.setMatiere(mat);
		exam.setType(createDto.getTypeExamen());
		return exam;
	}

	@Override
	public ExamenCreateDto convertEntityToCreateDto(Examen entity) {
		ExamenCreateDto examdto = new ExamenCreateDto();
		examdto.setCoefExamen(entity.getCoef());
		examdto.setDateExamen(entity.getDate());
		examdto.setMatiereExamen(entity.getMatiere().getNom());
		examdto.setTypeExamen(entity.getType());
		
		return examdto;
	}

	@Override
	public Examen convertUpdateDtoToEntity(ExamenUpdateDto updateDto) {
		Examen exam = new Examen();
		exam.setCoef(updateDto.getCoefExamen());
		exam.setDate(updateDto.getDateExamen());
		Matiere mat =serviceMat.readByNom(updateDto.getMatiereExamen());
		exam.setMatiere(mat);
		exam.setType(updateDto.getTypeExamen());
		exam.setId(updateDto.getIdExam());
		return exam;
	}

	@Override
	public ExamenUpdateDto convertEntityToUpdateDto(Examen entity) {
		ExamenUpdateDto examdto = new ExamenUpdateDto();
		examdto.setCoefExamen(entity.getCoef());
		examdto.setDateExamen(entity.getDate());
		examdto.setMatiereExamen(entity.getMatiere().getNom());
		examdto.setTypeExamen(entity.getType());
		examdto.setIdExam(entity.getId());
		
		return examdto;
	}

	@Override
	public List<Examen> convertListCreateDtoToEntity(List<ExamenCreateDto> listeCreateDto) {
		List<Examen> exams = new ArrayList<Examen>();
		for(ExamenCreateDto e : listeCreateDto) {
			exams.add(convertCreateDtoToEntity(e));
		}
		return exams;
	}

	@Override
	public List<ExamenCreateDto> convertListEntityToCreateDto(List<Examen> listeEntity) {
		List<ExamenCreateDto> exams = new ArrayList<ExamenCreateDto>();
		for(Examen e : listeEntity) {
			exams.add(convertEntityToCreateDto(e));
		}
		return exams;
	}

	@Override
	public List<Examen> convertListUpdateDtoToEntity(List<ExamenUpdateDto> listeUpdateDto) {
		List<Examen> exams = new ArrayList<Examen>();
		for(ExamenUpdateDto e : listeUpdateDto) {
			exams.add(convertUpdateDtoToEntity(e));
		}
		return exams;
	}

	@Override
	public List<ExamenUpdateDto> convertListEntityToUpdateDto(List<Examen> listeEntity) {
		List<ExamenUpdateDto> exams = new ArrayList<ExamenUpdateDto>();
		for(Examen e : listeEntity) {
			exams.add(convertEntityToUpdateDto(e));
		}
		return exams;
	}

	
	
}
