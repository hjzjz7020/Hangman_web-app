<%--
  Created by IntelliJ IDEA.
  User: jingzezheng
  Date: 8/30/21
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">test findAll</a><br/>

    <h3>test savePlayer</h3>
    <form action="account/savePlayer" method="post">
        name: <input type="text" name="player_name"/><br/>
        password: <input type="password" name="password"/><br/>
        status: <input type="text" name="management_status"/><br/>
        <input type="submit" value="Save"><br/>
    </form>

    <a href="game/newGame">Start Hangman</a><br/>
    <a href="management/">Management Page</a><br/>

</body>
</html>
