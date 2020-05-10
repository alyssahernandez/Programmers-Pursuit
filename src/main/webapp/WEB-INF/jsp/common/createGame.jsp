<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<div>

	<h2>
		<c:out value="Create a Game!" />
	</h2>



	<c:url var="createGameURL" value="/create" />

	<form action="${createGameURL }" method="POST">

		<label for="nickname">Nickname:</label>
		<input type="text" name="nickname" />
		
		<label for="gameCode">Game Code:</label> 
		<input type="text" name="gameCode" />
		
		<input type="submit" class="button" value="Start Game!" />

	</form>



</div>


