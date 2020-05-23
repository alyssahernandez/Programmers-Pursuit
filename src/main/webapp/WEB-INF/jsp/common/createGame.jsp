<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<div>

	<h2><c:out value="Create a Game!" /></h2>



	<c:url var="createGameURL" value="/create" />

	<form:form action="${createGameURL }" method="POST" modelAttribute="createGame">
		<!--  
		<label for="nickname">Nickname:</label>
		<input type="text" name="nickname" /
		
		<label for="gameCode">Game Code:</label> 
		<input type="text" name="gameCode" />
		-->
		<span>Categories:</span>
		<c:forEach var="category" items="${categories }">
			<form:label path="selectedCategories">${category.categoryName }</form:label> 
			<form:checkbox path="selectedCategories" value="${category.categoryId }" />
		</c:forEach>
		<form:label path="publicOrPrivate">Access:</form:label>
		<form:select path="publicOrPrivate">
			<form:option value="">Select public or private:</form:option>
			<form:option value="public">Public</form:option>
			<form:option value="private">Private</form:option>
		</form:select>
		<form:errors path="selectedCategories" cssClass="error"/>
		<form:errors path="publicOrPrivate" cssClass="error"/>		
		
		<input type="submit" class="button" value="Start Game!" />

	</form:form>

</div>

<style>
#invite {
	border: 1px solid white;
}
</style>


