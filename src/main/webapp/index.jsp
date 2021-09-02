<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome to Hangman!</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/main.css" />

</head>
<body>
	<section class="jumbotron">
		<h1>Hangman Game</h1>

		<p>
			<a id="newGameButton" class="btn btn-primary btn-lg">Start A New Game</a>
		</p>
		<div class="col-xs-3">
			<label for="gameIdInputBox">Game ID:
			</label><input type="text" class="form-control" id="gameIdInputBox">
			<a id="resumeGameButton" class="btn btn-primary btn-lg">Resume A Game</a>
		</div>
		<form action="management">
			<input type="submit" value="Management page" />
		</form>
	</section>

	<section id="gamePanel" class="panel panel-default hidden">
		<div class="panel-body">
			<span id="caption">You have {10} tries</span>
			<div id="currentGuess">G__GLE</div>
			
			<div class="inputWrapper">
				<input id="letterInput" type="text" placeholder="Enter your letter here"/>
				<a id="guessButton" class="btn btn-primary">Guess</a>
			</div>
		</div>

		<div>
			<h3>Current game id: </h3><p id="gameID"></p>
		</div>

		<div>
			<p id="message"></p>
		</div>

	</section>

</body>
</html>
