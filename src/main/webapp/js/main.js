$(function() {
	
	var newGameButton = $('#newGameButton'),
		guessButton = $('#guessButton'),
		letterInputBox = $('#letterInput'),
		caption = $('#caption'),
		currentGuess = $('#currentGuess'),
		gamePanel = $('#gamePanel'),
		message = $('#message'),
		currentGame = {};
	
	newGameButton.click(createNewGame);
	guessButton.click(makeGuess);
	
	function createNewGame () {
		$.ajax({
			url : "game/",
			type: 'POST'
		}).done(function (game) {
			currentGame = game;
			renderGame(game);
			gamePanel.removeClass('hidden');
			message.text('');
		});		
	}
	
	function makeGuess() {
		$.ajax({
			url : evalTempl('game/{id}?letter={letter}', {id: currentGame.id, letter: letterInputBox.val()}),
			type: 'PUT'
		}).done(function (game) {
			renderGame(game);
			checkGameState(currentGame, game);
			currentGame = game;
			letterInputBox.focus();
			letterInputBox.val('');
		});
	}
	
	function checkGameState(currentGame, game) {
		if (game.gameState === "WON") {
			message.text('You win!');
		} else if (game.gameState === "LOST") {
			message.text('You lose!');
		} else {
			message.text('Keep going!');
		}
	}
	
	function renderGame(game) {
		caption.text(evalTempl("You have {remainingGuesses} tries.", game));
		currentGuess.text(game.currentGuess);
	}
	
	// Useful string replace util for basic templating
	function evalTempl (str, context) {
		return str.replace(/\{(.*?)\}/g, function(match, key) {return context[key];});
	}
});
