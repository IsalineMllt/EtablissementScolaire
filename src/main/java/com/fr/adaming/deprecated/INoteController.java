package com.fr.adaming.deprecated;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.IController;
import com.fr.adaming.dto.NoteCreateDto;
import com.fr.adaming.dto.NoteUpdateDto;

@RequestMapping(path ="/note")
public interface INoteController extends IController<NoteCreateDto, NoteUpdateDto> {

	
}
