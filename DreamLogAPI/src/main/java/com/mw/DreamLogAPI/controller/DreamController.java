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
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/")
	public String index() {
		return "<h1>Welcome to DreamLog</h1>";
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dream/{id}")
	public Dream getDream(@PathVariable Long id) {
		return dreamServiceImpl.getDreamUsingId(id);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams")
	public ArrayList<Dream> getAllDreams() {
		return dreamServiceImpl.getAll();
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@PostMapping("/dream")
	public void saveDream(@RequestBody Dream dream) {
		 dreamServiceImpl.saveDream(dream);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@DeleteMapping("/dreams")
	public void deleteAllTheDreams() {
		dreamServiceImpl.deleteAllDreams();
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@DeleteMapping("/dream/{id}")
	public void deleteDream(@PathVariable Long id) {
		dreamServiceImpl.deleteDreamUsingId(id);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@PutMapping("/dream/{id}")
	public void updateDream(@RequestBody @PathVariable Long id, Dream dream) {
		dreamServiceImpl.updateDream(id, dream);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams/islucid")
	public ArrayList<Dream> getLucidDreams(@RequestParam Boolean isLucid) {
		return dreamServiceImpl.filterLucidDreams(isLucid);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams/isnightmare")
	public ArrayList<Dream> getNightmareDreams(@RequestParam Boolean isNightmare) {
		return dreamServiceImpl.filterNightmareDreams(isNightmare);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams/isrecurring")
	public ArrayList<Dream> getRecurringDreams(@RequestParam Boolean isRecurring) {
		return dreamServiceImpl.filterRecurringDreams(isRecurring);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams/isstrange")
	public ArrayList<Dream> getStrangeDreams(@RequestParam Boolean isStrange) {
		return dreamServiceImpl.filterStrangeDreams(isStrange);
	}
	
	@CrossOrigin(origins= "https://dreamlogfrontend.herokuapp.com/")
	@GetMapping("/dreams/isvivid")
	public ArrayList<Dream> getVividDreams(@RequestParam Boolean isVivid) {
		return dreamServiceImpl.filterVividDreams(isVivid);
	}
}
