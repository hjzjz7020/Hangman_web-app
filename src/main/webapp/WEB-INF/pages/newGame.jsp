<%--
  Created by IntelliJ IDEA.
  User: jingzezheng
  Date: 8/31/21
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Welcome to Hangman Game!</title>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/main.css" />
</head>
<body>

<%--    <section class="jumbotron">--%>
<%--        <h1>Hangman</h1>--%>
<%--        <p>Try to guess the word.</p>--%>
<%--        <p>--%>
<%--            <a id="newGameButton" class="btn btn-primary btn-lg">Start A New Game</a>--%>
<%--            <span id="stats"></span>--%>
<%--        </p>--%>
<%--    </section>--%>

    <section id="gamePanel" class="panel panel-default hidden">
        <div class="panel-body">
            <span id="caption">You have {10} tries. Guess this {7} letter word:</span>
            <div id="currentGuess">G__GLE</div>

            <div class="inputWrapper">
                <input id="letterInput" type="text" placeholder="Enter your letter here"/>
                <a id="guessButton" class="btn btn-primary">Guess</a>
            </div>
        </div>

        <div>
            <p id="message"></p>
            <img id="hangmanImage" src="images/0.png" alt="hangman image"/>
            <div><small>Picture taken from http://www.thegamegal.com/ and modified for this app</small></div>
        </div>
    </section>

</body>
</html>
