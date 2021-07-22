package com.organization.mvcproject.service;

import java.util.List;

import com.organization.mvcproject.model.Game;

public interface Game_Service {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
