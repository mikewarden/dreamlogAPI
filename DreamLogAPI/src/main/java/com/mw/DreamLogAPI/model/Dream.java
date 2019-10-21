package com.mw.DreamLogAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String title;
	private String body;
	private String date;
	private Boolean isLucid;
	private Boolean isNightmare;
	private Boolean isRecurring;
	private Boolean isStrange;
	private Boolean isVivid;
	private Long rating;
	
	
	public Dream() {};


	public Dream(String name, String title, String body, String date, Boolean isLucid, Boolean isNightmare,
			Boolean isRecurring, Boolean isStrange, Boolean isVivid, Long rating) {
		
		this.name = name;
		this.title = title;
		this.body = body;
		this.date = date;
		this.isLucid = isLucid;
		this.isNightmare = isNightmare;
		this.isRecurring = isRecurring;
		this.isStrange = isStrange;
		this.isVivid = isVivid;
	}


	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Boolean getIsLucid() {
		return isLucid;
	}


	public void setIsLucid(Boolean isLucid) {
		this.isLucid = isLucid;
	}


	public Boolean getIsNightmare() {
		return isNightmare;
	}


	public void setIsNightmare(Boolean isNightmare) {
		this.isNightmare = isNightmare;
	}


	public Boolean getIsRecurring() {
		return isRecurring;
	}


	public void setIsRecurring(Boolean isRecurring) {
		this.isRecurring = isRecurring;
	}


	public Boolean getIsStrange() {
		return isStrange;
	}


	public void setIsStrange(Boolean isStrange) {
		this.isStrange = isStrange;
	}


	public Boolean getIsVivid() {
		return isVivid;
	}


	public void setIsVivid(Boolean isVivid) {
		this.isVivid = isVivid;
	}
	
	

	public Long getRating() {
		return rating;
	}


	public void setRating(Long rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Dream [id=" + id + ", name=" + name + ", title=" + title + ", body=" + body + ", date=" + date
				+ ", isLucid=" + isLucid + ", isNightmare=" + isNightmare + ", isRecurring=" + isRecurring
				+ ", isStrange=" + isStrange + ", isVivid=" + isVivid + ", rating=" + rating + "]";
	}


	


	
	
	
	
	
	
	
}
