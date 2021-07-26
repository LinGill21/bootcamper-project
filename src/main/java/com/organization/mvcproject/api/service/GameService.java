package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.model.Game;
public interface GameService {

	List<Game> retrieveAllGames();
	Game findGameById(Long id); 
	boolean deleteGame(Long  id);
	Game saveGame(Game game);

}
