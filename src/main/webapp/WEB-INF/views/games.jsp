<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="navTag"%>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/app.modules.js" /></script>
        <script src="resources/static/js/service/game.service.js"></script>
        <script src="resources/static/js/controller/game.controller.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library - Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="GameApp" class="ng-cloak">
		<navTag:navtag/>
        <br>
        <div class="container" ng-controller="GameController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.game.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="name">Name*</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.game.name" id="name" class="game_name form-control input-sm" placeholder="Enter the name of the new game [required]" required ng-minlength="3" />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.name.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.name.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.name.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="genre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.game.genre" id="genre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input data-ng-if ="!ctrl.game.id" type="submit" value="Add" class="btn btn-primary btn-sm">
                                <button data-ng-if ="ctrl.game.id" type="submit" class="btn btn-primary btn-sm">Update</button>
                                <button data-ng-if="ctrl.game" type="reset" class="btn btn-secondary btn-sm" data-ng-click="ctrl.clearGame()">Clear</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
                   <select data-ng-options="genre for genre in ctrl.genres" 
        					data-ng-model="ctrl.selectedGenre"
        					data-ng-change="ctrl.fetchAllGames()">
					</select>
                <div class="tablecontainer">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Game Name</th>
                                <th>Game Genre</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentGame in ctrl.games">
                                <td><span ng-bind="currentGame.name"></span></td>
                                <td><span ng-bind="currentGame.genre"></span></td>
                                 <td><button data-ng-click="ctrl.updateGame(currentGame)" type="button" class="btn btn-primary">Update</button></td>
                                <td><button data-ng-click="ctrl.deleteGame(currentGame)" type="button" class="btn btn-danger">Delete</button></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript"></script>

    </html>