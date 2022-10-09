package com.cgi.cmatch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;


@Document(collection = "newmatch")
public class NewMatchRecommend {
	@Id
	private String id;
	private String email;
	private	String unique_id;
	private String date;
	private String dateTimeGMT;
	@JsonProperty("team-1")
	private String team1;
	@JsonProperty("team-2")
	private String team2;
	private String  type;
	private String squad;
	private String toss_winner_team;
	private String matchStarted;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateTimeGMT() {
		return dateTimeGMT;
	}
	public void setDateTimeGMT(String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSquad() {
		return squad;
	}
	public void setSquad(String squad) {
		this.squad = squad;
	}
	public String getToss_winner_team() {
		return toss_winner_team;
	}
	public void setToss_winner_team(String toss_winner_team) {
		this.toss_winner_team = toss_winner_team;
	}
	public String getMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(String matchStarted) {
		this.matchStarted = matchStarted;
	}

	@Override
	public String toString() {
		return "NewMatchRecommend [id=" + id + ", email=" + email + ", unique_id=" + unique_id + ", date=" + date
				+ ", dateTimeGMT=" + dateTimeGMT + ", team1=" + team1 + ", team2=" + team2 + ", type=" + type
				+ ", squad=" + squad + ", toss_winner_team=" + toss_winner_team + ", matchStarted=" + matchStarted
				+ "]";
	}

	/*public NewMatchRecommend( String unique_id, String date, String dateTimeGMT, String team1, String team2,
			String type, String squad, String toss_winner_team, String matchStarted) {
		super();
		
		this.unique_id = unique_id;
		this.date = date;
		this.dateTimeGMT = dateTimeGMT;
		this.team1 = team1;
		this.team2 = team2;
		this.type = type;
		this.squad = squad;
		this.toss_winner_team = toss_winner_team;
		this.matchStarted = matchStarted;
	}*/
	

	public NewMatchRecommend() {
		super();
	}

	public NewMatchRecommend(String id, String email, String unique_id, String date, String dateTimeGMT, String team1,
			String team2, String type, String squad, String toss_winner_team, String matchStarted) {
		super();
		this.id = id;
		this.email = email;
		this.unique_id = unique_id;
		this.date = date;
		this.dateTimeGMT = dateTimeGMT;
		this.team1 = team1;
		this.team2 = team2;
		this.type = type;
		this.squad = squad;
		this.toss_winner_team = toss_winner_team;
		this.matchStarted = matchStarted;
	}
	
	
	
	


}
