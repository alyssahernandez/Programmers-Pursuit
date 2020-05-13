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
		
		<c:forEach var="category" items="${categories }">
			<label for="categorySelection">${category.categoryName }</label> 
			<input type="checkbox" name="categorySelection" value="${category.categoryId }" />
		</c:forEach>
		
		<input type="submit" class="button" value="Start Game!" />

	</form>



</div>


