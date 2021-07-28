package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.GameDaoImpl;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.Game;

@Service("gameService")
public class GameServiceImpl implements GameService {
	@Autowired
	private GameDaoImpl mockdao;
	@Override
	public List<Game> retrieveAllGames() {
		return mockdao.findAllGames();
	}
	@Override
	public Game findGameById(Long id)  {
		return mockdao.findGameById(id);
	}
	@Override
	public boolean deleteGame(Long  id) {
		return mockdao.deleteGame(id);
	}
	@Override
	public Game saveGame(Game game) {
		return mockdao.saveGame(game);
	}

}