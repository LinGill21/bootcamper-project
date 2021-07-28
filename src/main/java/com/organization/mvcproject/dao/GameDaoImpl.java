package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.organization.mvcproject.model.Game;
@Repository("GameDaoImpl")
public class  GameDaoImpl{

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	public List<Game> findAllGames() {
		return games;
	}

	
	public Game saveGame(Game game) {
		if(game.getId() != null) {
			return findGameById(game.getId());
		}
		else {
			 game.setId(++gameId);
		     games.add((Game) game);
		     return game; 
		}
	}
	
	
	public Game findGameById(Long id) {
		for(Game game:games) {
			if(game.getId() == id) {
				return game;
			}
		}
		return new Game();
	}

	public boolean deleteGame(Long id) {
		System.out.println("in Dao");
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