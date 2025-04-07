package com.votting.vottingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Poll")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Poll
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	@ElementCollection
	private List<OptionVote> options = new ArrayList<>();
//	@ElementCollection
//	private List<Long> votes = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<OptionVote> getOptions() {
		return options;
	}
	
	public void setOptions(List<OptionVote> options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return "Poll{" +
			"id=" + id +
			", question='" + question + '\'' +
			", options=" + options +
			'}';
	}
}
