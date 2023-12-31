package com.estudandojava.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandojava.dslist.dto.GameDTO;
import com.estudandojava.dslist.dto.GameMinDTO;
import com.estudandojava.dslist.exceptions.UnsupportedGetException;
import com.estudandojava.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) throws Exception{
	   GameDTO result = gameService.findById(id);
	   if (result == null) {
		   System.out.print("estamos aqui.");
		   throw new UnsupportedGetException("This id game not exists!");	
	   }
       return result;
	}
}
