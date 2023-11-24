package com.estudandojava.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudandojava.dslist.dto.GameListDTO;
import com.estudandojava.dslist.dto.GameMinDTO;
import com.estudandojava.dslist.entities.GameList;
import com.estudandojava.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly=true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		//List<GameMinDTO> dto =  result.stream().map(mapper -> new GameMinDTO(mapper)).toList();		
		List<GameListDTO> dto = result.stream().collect(
														Collectors.mapping(x -> new GameListDTO(x), 
																Collectors.toList())
				                                         );
		return dto;
	}
}
