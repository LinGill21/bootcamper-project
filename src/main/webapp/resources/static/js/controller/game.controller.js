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

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
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

			self.fetchAllGames();
		} ]);
