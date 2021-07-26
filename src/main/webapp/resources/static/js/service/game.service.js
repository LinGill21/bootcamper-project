'use strict';

angular.module('GameApp').factory('GameService', ['$http', function($http) {

		var REST_SERVICE_URI = '';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame
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
			return $http.get(REST_SERVICE_URI + '/{id}', game).then(function(response) {
					return response.data;
				}
			);
		}
		function  deleteGamesbyId(id) {
			return $http.post(REST_SERVICE_URI + '/{id}', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		

}]);
