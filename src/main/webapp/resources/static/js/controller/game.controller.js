'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];
			self.genres = [{name: 'All'}]; 
			self.selectedGenre = '';
			
			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
					self.genres =generateGenreList();
				});
			}

			self.addGame = function(){
				if(!self.game.id){
					return GameService.createGame(self.game).then( function() {
						self.fetchAllGames();
						self.game = {};
					});
				}else{
					return GameService.updateGame(self.game).then( function() {
						self.fetchAllGames();
						self.game = {};
					});
				}
			}
			
			self.deleteGame = function(game){
				return GameService.deleteGame(game.id).then( function() {
				self.fetchAllGames();
				});
			}
			self.updateGame = function(game){
				self.game= angular.copy(game);
			}
			self.clearGame= function(){
				self.game={};
			}
			function generateGenreList (){
				let genreSet = new Set();
				for (let i = 0; i < self.games.length; i++) {
  					genreSet.add (self.games[i].genre);
				}
				return Array.from(genreSet);
			}
			self.fetchAllGames();
		} ]);
