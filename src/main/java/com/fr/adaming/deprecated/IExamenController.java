package com.fr.adaming.deprecated;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.IController;
import com.fr.adaming.dto.ExamenCreateDto;
import com.fr.adaming.dto.ExamenUpdateDto;

@RequestMapping ( path = "/examen" )
public interface IExamenController extends IController<ExamenCreateDto, ExamenUpdateDto> {

}
