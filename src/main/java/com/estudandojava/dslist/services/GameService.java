package com.estudandojava.dslist.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandojava.dslist.dto.GameMinDTO;
import com.estudandojava.dslist.entities.Game;
import com.estudandojava.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		//List<GameMinDTO> dto =  result.stream().map(mapper -> new GameMinDTO(mapper)).toList();
		
		List<GameMinDTO> dto = result.stream().collect(
														Collectors.mapping(x -> new GameMinDTO(x), 
																Collectors.toList())
				                                         );
		return dto;
	}
}
