package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;
@Repository("GameDaoImpl")
public class  GameDaoImpl{

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	public List<Game> findAllGames() {
		return ImmutableList.copyOf(games);
	}

	
	public Game saveGame(Game game) {
		if(game.getId() != null) {
			return findGameById(game.getId());
		}
		else {
			 game.setId(++gameId);
		     games.add((GameImpl) game);
		     return game; 
		}
	}
	
	
	public Game findGameById(Long id) {
		for(Game game:games) {
			if(game.getId() == id) {
				return game;
			}
		}
		return null;
	}

	public boolean deleteGame(Long id) {
		Game gameRemoved =findGameById(id);
		if(gameRemoved != null) {
			try {
			games.removeIf(game-> id == game.getId());
			return true;
			}
			catch(Error e){
				return false;
			}
		}
		return false;
	}

	
	public List<Game> findGamesByGenre(String genre) {
        return games.stream()  
                .filter(g ->g.getGenre() == genre) 
                .collect(Collectors.toList());  
		
	}
	
	
}