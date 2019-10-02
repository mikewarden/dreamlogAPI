package com.mw.DreamLogAPI.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mw.DreamLogAPI.model.Dream;

public interface DreamRepository extends CrudRepository<Dream, Long> {

	public Dream findDreamById(Long id);
	public ArrayList<Dream> findAll();
	public ArrayList<Dream> findAllDreamsByIsLucid(Boolean isLucid);
	public ArrayList<Dream> findAllDreamsByIsNightmare(Boolean isNightmare);
	public ArrayList<Dream> findAllDreamsByIsRecurring(Boolean isRecurring);
	public ArrayList<Dream> findAllDreamsByIsStrange(Boolean isStrange);
	public ArrayList<Dream> findAllDreamsByIsVivid(Boolean isVivid);

}
