package com.mw.DreamLogAPI.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mw.DreamLogAPI.model.Dream;
import com.mw.DreamLogAPI.service.DreamServiceImpl;

@RestController
public class DreamController {
	
	@Autowired
	private DreamServiceImpl dreamServiceImpl;
	
	@GetMapping("/dream/{id}")
	public Dream getDream(@PathVariable Long id) {
		return dreamServiceImpl.getDreamUsingId(id);
	}
	
	@GetMapping("/dreams")
	public ArrayList<Dream> getAllDreams() {
		return dreamServiceImpl.getAll();
	}
	
	@PostMapping("/dream")
	public void saveDream(Dream dream) {
		 dreamServiceImpl.saveDream(dream);
	}
	
	@DeleteMapping("/dreams")
	public void deleteAllTheDreams() {
		dreamServiceImpl.deleteAllDreams();
	}
	
	@DeleteMapping("/dream/{id}")
	public void deleteDream(@PathVariable Long id) {
		dreamServiceImpl.deleteDreamUsingId(id);
	}
	
	@PutMapping("/dream/{id}")
	public void updateDream(@PathVariable Long id, Dream dream) {
		dreamServiceImpl.updateDream(id, dream);
	}
	
	@GetMapping("/dreams/islucid")
	public ArrayList<Dream> getLucidDreams(@RequestParam Boolean isLucid) {
		return dreamServiceImpl.filterLucidDreams(isLucid);
	}
	
	@GetMapping("/dreams/isnightmare")
	public ArrayList<Dream> getNightmareDreams(@RequestParam Boolean isNightmare) {
		return dreamServiceImpl.filterNightmareDreams(isNightmare);
	}
	
	@GetMapping("/dreams/isrecurring")
	public ArrayList<Dream> getRecurringDreams(@RequestParam Boolean isRecurring) {
		return dreamServiceImpl.filterRecurringDreams(isRecurring);
	}
	
	@GetMapping("/dreams/isstrange")
	public ArrayList<Dream> getStrangeDreams(@RequestParam Boolean isStrange) {
		return dreamServiceImpl.filterStrangeDreams(isStrange);
	}
	
	@GetMapping("/dreams/isvivid")
	public ArrayList<Dream> getVividDreams(@RequestParam Boolean isVivid) {
		return dreamServiceImpl.filterVividDreams(isVivid);
	}
}
