package com.estudandojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandojava.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
