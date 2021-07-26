package com.organization.mvcproject.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface GameDao {
	public List<Game> findAllGames();
	public Game saveGame(Game game);
	public Game findGameById(Long id);
	boolean deleteGame(Long id);
	List<Game> findGamesByGenre(String genre);
}
