package com.mw.DreamLogAPI.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mw.DreamLogAPI.model.Dream;
import com.mw.DreamLogAPI.service.DreamServiceImpl;

@RestController
public class DreamController {
	
	@Autowired
	private DreamServiceImpl dreamServiceImpl;
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/")
	public String index() {
		return "<h1>Welcome to DreamLog</h1>";
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dream/{id}")
	public Dream getDream(@PathVariable Long id) {
		return dreamServiceImpl.getDreamUsingId(id);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams")
	public ArrayList<Dream> getAllDreams() {
		return dreamServiceImpl.getAll();
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@PostMapping("/dream")
	public void saveDream(@RequestBody Dream dream) {
		 dreamServiceImpl.saveDream(dream);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@DeleteMapping("/dreams")
	public void deleteAllTheDreams() {
		dreamServiceImpl.deleteAllDreams();
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@DeleteMapping("/dream/{id}")
	public void deleteDream(@PathVariable Long id) {
		dreamServiceImpl.deleteDreamUsingId(id);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@PutMapping("/dream/{id}")
	public void updateDream(@RequestBody @PathVariable Long id, Dream dream) {
		dreamServiceImpl.updateDream(id, dream);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams/islucid")
	public ArrayList<Dream> getLucidDreams(@RequestParam Boolean isLucid) {
		return dreamServiceImpl.filterLucidDreams(isLucid);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams/isnightmare")
	public ArrayList<Dream> getNightmareDreams(@RequestParam Boolean isNightmare) {
		return dreamServiceImpl.filterNightmareDreams(isNightmare);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams/isrecurring")
	public ArrayList<Dream> getRecurringDreams(@RequestParam Boolean isRecurring) {
		return dreamServiceImpl.filterRecurringDreams(isRecurring);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams/isstrange")
	public ArrayList<Dream> getStrangeDreams(@RequestParam Boolean isStrange) {
		return dreamServiceImpl.filterStrangeDreams(isStrange);
	}
	
	@CrossOrigin(origins= "http://localhost:3000")
	@GetMapping("/dreams/isvivid")
	public ArrayList<Dream> getVividDreams(@RequestParam Boolean isVivid) {
		return dreamServiceImpl.filterVividDreams(isVivid);
	}
}
