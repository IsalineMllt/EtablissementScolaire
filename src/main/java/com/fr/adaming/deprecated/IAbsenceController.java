package com.fr.adaming.deprecated;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.IController;
import com.fr.adaming.dto.AbsenceCreateDto;
import com.fr.adaming.dto.AbsenceUpdateDto;

@RequestMapping(path = "/absence")
public interface IAbsenceController extends IController<AbsenceCreateDto, AbsenceUpdateDto>{

}
