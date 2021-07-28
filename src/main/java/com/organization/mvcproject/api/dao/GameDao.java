package com.organization.mvcproject.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.organization.mvcproject.model.Game;

public interface GameDao {
	List<Game> findAllGames();
	Game saveGame(Game game);
    Game findGameById(Long id);
	boolean deleteGame(Long id);
	List<Game> findGamesByGenre(String genre);
}
