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
    <title>Title</title>
</head>
<body>
    <h3>All game information</h3>
    <c:forEach items="${list}" var="game">
        ${game.id}
        ${game.gameState}
        ${game.word}
        ${game.playerId}
    </c:forEach>
</body>
</html>
