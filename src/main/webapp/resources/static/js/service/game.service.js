'use strict';

angular.module('GameApp').factory('GameService', ['$http', function($http) {

		var REST_SERVICE_URI = '';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame :deleteGame,
			updateGame: updateGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'createGame', game).then(function(response) {
					return response.data;
				}
			);
		}
		function findGameById(id) {
			return $http.get(REST_SERVICE_URI + '/game/{id}', id).then(function(response) {
					return response.data;
				}
			);
		}
		function  deleteGame(gameId) {
			return $http.delete(REST_SERVICE_URI + '/game/'+gameId+'/delete').then(function(response) {
					return response.data;
				}
			);
		}
		function  updateGame(game) {
			return $http.post(REST_SERVICE_URI + '/game/'+game.id+'/update',game).then(function(response) {
					return response.data;
				}
			);
		}
		
		

}]);
