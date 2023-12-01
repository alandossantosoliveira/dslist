package com.estudandojava.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudandojava.dslist.dto.GameDTO;
import com.estudandojava.dslist.dto.GameMinDTO;
import com.estudandojava.dslist.entities.Game;
import com.estudandojava.dslist.projections.GameMinProjection;
import com.estudandojava.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly=true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		//List<GameMinDTO> dto =  result.stream().map(mapper -> new GameMinDTO(mapper)).toList();		
		List<GameMinDTO> dto = result.stream().collect(
														Collectors.mapping(x -> new GameMinDTO(x), 
																Collectors.toList())
				                                         );
		return dto;
	}
	
	@Transactional(readOnly=true)
	public List<GameMinDTO> searchByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		//List<GameMinDTO> dto =  result.stream().map(mapper -> new GameMinDTO(mapper)).toList();		
		List<GameMinDTO> dto = result.stream().collect(
														Collectors.mapping(x -> new GameMinDTO(x), 
																Collectors.toList())
				                                         );
		return dto;
	}
	
	@Transactional(readOnly=true)
	public GameDTO findById(Long id) {
		GameDTO dto = null;
		if (gameRepository.existsById(id)) {
			Game result = gameRepository.findById(id).get();
			dto = new GameDTO(result);
			System.out.println("Game existe!");
		}else {
			System.out.println("Game não existe!");
		}
		return dto;
	}
}
