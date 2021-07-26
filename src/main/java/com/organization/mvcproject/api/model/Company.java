package com.organization.mvcproject.api.model;

import java.util.List;
import com.organization.mvcproject.api.model.Game;
public interface Company {
	Long getId();
	void setId(Long id);
	String getName();

	void setName(String name);

	List<Game> getGamesMade();
	void setGamesMade(List<Game> gamesMade);
}
