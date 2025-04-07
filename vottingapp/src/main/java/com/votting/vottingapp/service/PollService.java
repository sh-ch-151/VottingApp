package com.votting.vottingapp.service;

import com.votting.vottingapp.dao.PollRepository;
import com.votting.vottingapp.model.OptionVote;
import com.votting.vottingapp.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService
{
	@Autowired
	PollRepository repo;
	
	public Poll createPoll(Poll poll)
	{
		return repo.save(poll);
	}
	
	public List<Poll> getAllPolls()
	{
		return repo.findAll();
	}
	
	public Optional<Poll> getPollByid(int id)
	{
		return Optional.of(repo.getReferenceById(id));
	}
	
	public void vote(int pollId, int optionIndex)
	{
		//Get poll from zdb
		Poll poll = repo.findById(pollId)
			.orElseThrow(() -> new RuntimeException("Poll not found"));
	
	//get all options
		List<OptionVote> options = poll.getOptions();
		// If index for vote is not valid , throw error
		if(optionIndex < 0 || optionIndex >= options.size())
		{
			throw new IllegalArgumentException("Invalid option index");
		}
		//Get selected option
		OptionVote selectedOption = options.get(optionIndex);
		
		//Increment vote for selected option
		
		selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
		//Save incremeted option into te database;
		repo.save(poll);
	}
}
