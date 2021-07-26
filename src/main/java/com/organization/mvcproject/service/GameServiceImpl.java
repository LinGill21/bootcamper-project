package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.MockDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService {
	@Autowired
	private MockDAO mockdao;

	@Override
	public List<Game> retrieveAllGames() {
		return mockdao.findAllGames();
	}

	public Game findGameById(Long id)  {
		return mockdao.findGameById(id);
	}

	public boolean deleteGame(Long  id) {
		return mockdao.deleteGame(id);
	}
	@Override
	public Game saveGame(Game game) {
		return mockdao.saveGame(game);
	}

}