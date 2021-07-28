package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameDao {
	List<Game> findAllGames();
	Game saveGame(Game game);
    Game findGameById(Long id);
	boolean deleteGame(Long id);
	List<Game> findGamesByGenre(String genre);
}
