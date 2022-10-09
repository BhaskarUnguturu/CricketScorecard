package com.cgi.cmatch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "oldrecommend")
public class OldMatchRecommend {
	@Id
	private String id;
	private String email;
	private String unique_id;
	private String title;
	private String description;

	public OldMatchRecommend() {
	}

	

	

	public OldMatchRecommend(String id, String email, String unique_id, String title, String description) {
		super();
		this.id = id;
		this.email = email;
		this.unique_id = unique_id;
		this.title = title;
		this.description = description;
	}





	public String getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Recommend [id=" + id + ", email=" + email + ", unique_id=" + unique_id + ", title=" + title
				+ ", description=" + description + "]";
	}
	
}
