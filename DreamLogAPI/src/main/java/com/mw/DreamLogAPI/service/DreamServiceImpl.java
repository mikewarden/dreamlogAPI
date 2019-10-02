package com.mw.DreamLogAPI.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.DreamLogAPI.model.Dream;
import com.mw.DreamLogAPI.repository.DreamRepository;

@Service
public class DreamServiceImpl implements DreamServiceInterface {
	
	@Autowired
	private DreamRepository dreamRepository;

	
	@Override
	public Dream getDreamUsingId(Long id) {
	
		return dreamRepository.findDreamById(id);
	}

	@Override
	public ArrayList<Dream> getAll() {
		return dreamRepository.findAll();
	}

	@Override
	public void saveDream(Dream dream) {
		 dreamRepository.save(dream);
	}

	@Override
	public void deleteAllDreams() {
		dreamRepository.deleteAll();
		
	}

	@Override
	public void deleteDreamUsingId(Long id) {
		dreamRepository.deleteById(id);
		
	}
	
	@Override
	public void updateDream(Long id, Dream dreamStatus) {
		
		Dream currentDream = dreamRepository.findDreamById(id);
		
		String title = dreamStatus.getTitle();
		String body = dreamStatus.getBody();
		String date = dreamStatus.getDate();
		Boolean isLucid = dreamStatus.getIsLucid();
		Boolean isNightmare = dreamStatus.getIsNightmare();
		Boolean isRecurring = dreamStatus.getIsRecurring();
		Boolean isStrange = dreamStatus.getIsStrange();
		Boolean isVivid = dreamStatus.getIsVivid();
		
		currentDream.setTitle(title);
		currentDream.setBody(body);
		currentDream.setDate(date);
		currentDream.setIsLucid(isLucid);
		currentDream.setIsNightmare(isNightmare);
		currentDream.setIsRecurring(isRecurring);
		currentDream.setIsStrange(isStrange);
		currentDream.setIsVivid(isVivid);
		
		dreamRepository.save(currentDream);
		
	}
	
	@Override
	public ArrayList<Dream> filterLucidDreams(Boolean isLucid) {
		return dreamRepository.findAllDreamsByIsLucid(isLucid);
	}
	
	@Override
	public ArrayList<Dream> filterNightmareDreams(Boolean isNightmare) {
		return dreamRepository.findAllDreamsByIsNightmare(isNightmare);
	}

	@Override
	public ArrayList<Dream> filterRecurringDreams(Boolean isRecurring) {
		return dreamRepository.findAllDreamsByIsRecurring(isRecurring);
	}
	
	@Override
	public ArrayList<Dream> filterStrangeDreams(Boolean isStrange) {
		return dreamRepository.findAllDreamsByIsStrange(isStrange);
	}

	@Override
	public ArrayList<Dream> filterVividDreams(Boolean isVivid) {
		return dreamRepository.findAllDreamsByIsVivid(isVivid);
	}

	
	
	
	
}