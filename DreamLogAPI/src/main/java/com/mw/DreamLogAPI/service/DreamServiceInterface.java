package com.mw.DreamLogAPI.service;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mw.DreamLogAPI.model.Dream;

@Repository
public interface DreamServiceInterface {

	public Dream getDreamUsingId(Long id);

	public ArrayList<Dream> getAll();

	public void saveDream(Dream dream);

	public void deleteAllDreams();

	public void deleteDreamUsingId(Long id);

	public void updateDream(Long id, Dream dream);

	public ArrayList<Dream> filterLucidDreams(Boolean isLucid);

	public ArrayList<Dream> filterNightmareDreams(Boolean isNightmare);

	public ArrayList<Dream> filterRecurringDreams(Boolean isRecurring);

	public ArrayList<Dream> filterStrangeDreams(Boolean isStrange);

	public ArrayList<Dream> filterVividDreams(Boolean isVivid);

	

	
}