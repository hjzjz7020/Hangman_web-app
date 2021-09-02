<%--
  Created by IntelliJ IDEA.
  User: jingzezheng
  Date: 8/30/21
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hangman Management.</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <h3>All game information</h3>
<%--    <c:forEach items="${list}" var="game">--%>
<%--        ${game.id}--%>
<%--        ${game.gameState}--%>
<%--        ${game.word}--%>
<%--        ${game.remainingGuesses}--%>
<%--        ${game.currentGuess}--%>
<%--    </c:forEach>--%>
<%--    <table>--%>
<%--        <c:forEach items="${list}" var="game">--%>
<%--            <tr>--%>
<%--                <th style="text-align:left">ID</th>--%>
<%--                <th style="text-align:left">State</th>--%>
<%--                <th style="text-align:left">Word</th>--%>
<%--                <th style="text-align:left">Remaining Chances</th>--%>
<%--                <th style="text-align:left">Current Guess</th>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><c:out value="${game.id}" /></td>--%>
<%--                <td><c:out value="${game.gameState}" /></td>--%>
<%--                <td><c:out value="${game.word}" /></td>--%>
<%--                <td><c:out value="${game.remainingGuesses}" /></td>--%>
<%--                <td><c:out value="${game.currentGuess}" /></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

    <table class="table table-bordered w-auto">
        <c:forEach items="${list}" var="game">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">State</th>
            <th scope="col">Word</th>
            <th scope="col">Remaining Chances</th>
            <th scope="col">Current Guess</th>
        </tr>
        </thead>
        <tbody>

            <tr>
            <td><c:out value="${game.id}" /></td>
            <td><c:out value="${game.gameState}" /></td>
            <td><c:out value="${game.word}" /></td>
            <td><c:out value="${game.remainingGuesses}" /></td>
            <td><c:out value="${game.currentGuess}" /></td>
            </tr>
        </tbody>
        </c:forEach>
    </table>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>