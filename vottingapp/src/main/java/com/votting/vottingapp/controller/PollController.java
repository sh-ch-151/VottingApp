package com.votting.vottingapp.controller;

import com.votting.vottingapp.model.Poll;
import com.votting.vottingapp.model.Vote;
import com.votting.vottingapp.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController
{
	@Autowired
	PollService serv;
	
	@PostMapping("")
	public Poll createPoll(@RequestBody Poll poll)
	{
		return serv.createPoll(poll);
	}
	
	@GetMapping("")
	public List<Poll> getAllPolls()
	{
		return serv.getAllPolls();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Poll> getAllPoll(@PathVariable int id)
	{
		return serv.getPollByid(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/vote")
	public void vote(@RequestBody Vote vote)
	{
		serv.vote(vote.getPollId(), vote.getOptionIndex());
	}
}
