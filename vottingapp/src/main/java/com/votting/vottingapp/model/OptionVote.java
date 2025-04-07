package com.votting.vottingapp.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote
{
	private String optionText;
	private int voteCount;
	
	public String getOptionText() {
		return optionText;
	}
	
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	
	public int getVoteCount() {
		return voteCount;
	}
	
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	@Override
	public String toString() {
		return "OptionVote{" +
			"optionText='" + optionText + '\'' +
			", voteCount=" + voteCount +
			'}';
	}
}
