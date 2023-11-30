package com.estudandojava.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudandojava.dslist.dto.GameListDTO;
import com.estudandojava.dslist.entities.GameList;
import com.estudandojava.dslist.projections.GameMinProjection;
import com.estudandojava.dslist.repositories.GameListRepository;
import com.estudandojava.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
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
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
		
		for (int i = min; i<=max; i++) {
			//updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
