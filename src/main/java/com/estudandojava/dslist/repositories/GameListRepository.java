package com.estudandojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandojava.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
