package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.adaming.entity.Note;

public interface INoteDao extends JpaRepository<Note,Integer> {

}
