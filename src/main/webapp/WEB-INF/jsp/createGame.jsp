<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div>

<h2><c:out value="Game Options"/></h2>

<c:url var="gameOptionsURL" value="/create"/>
<form action="${gameOptionsURL }" method="POST">

	<label for="gameCode">Game Code:</label>
	<input type="text" name="gameCode"/>
	
	<label for="numberOfPlayers">How Many Players:</label>
	
	<input type="radio" name="twoPlayers" value="2"/>
	<label for="twoPlayers">2 Players</label>
	
	<input type="radio" name="threePlayers" value="3"/>
	<label for="threePlayers">3 Players</label>
	
	<input type="radio" name="fourPlayers" value="4"/>
	<label for="fourPlayers">4 Players</label>
	
</form>





</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />