package com.votting.vottingapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vote
{
	private int pollId;
	private int optionIndex;
	
	public int getPollId() {
		return pollId;
	}
	
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	
	public int getOptionIndex() {
		return optionIndex;
	}
	
	public void setOptionIndex(int optionIndex) {
		this.optionIndex = optionIndex;
	}
	
	@Override
	public String toString() {
		return "Vote{" +
			"pollId=" + pollId +
			", optionIndex=" + optionIndex +
			'}';
	}
}
