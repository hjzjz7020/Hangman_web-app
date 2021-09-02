$(function() {
	
	// NOTE: This is a quick and dirty UI for the backend. In normal situations, 
	// there would be separation between the game controller, the view, and the game model.
	
	var newGameButton = $('#newGameButton'),
		guessButton = $('#guessButton'),
		letterInputBox = $('#letterInput'),
		caption = $('#caption'),
		currentGuess = $('#currentGuess'),
		gamePanel = $('#gamePanel'),
		message = $('#message'),
		currentGame = {};
		// gamesPlayed = 0,
		// gamesWon = 0;
	
	newGameButton.click(createNewGame);
	guessButton.click(makeGuess);
	
	function createNewGame () {
		$.ajax({
			url : "game",
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
		if (game.gameState === 1) {
			message.text('You won!');
		} else if (game.gameState === -1) {
			message.text('You lost!');
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
