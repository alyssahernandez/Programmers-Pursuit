<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="create">
	<h2 class="headers__create u-center-text u-margin-bottom-small"><c:out value="Create a Game" /></h2>

	<c:url var="createGameURL" value="/create" />

	<form class="create__form" action="${createGameURL }" method="POST">
		<!--  
		<label for="nickname">Nickname:</label>
		<input type="text" name="nickname" />
		
		<label for="gameCode">Game Code:</label> 
		<input type="text" name="gameCode" />
		 -->
		<h3 class="headers__create-categories">Topics:</h3>
		
		<div class="create__options">
			<c:forEach var="category" items="${categories }">
			<div class="create__form-group">
				<input class="create__checkbox" type="checkbox" name="categorySelection" id="${category.categoryName }" value="${category.categoryId }" />
				<label class="create__label labels__create" for="${category.categoryName }">${category.categoryName }</label>
			</div>
			</c:forEach>
		</div>
				
		<input type="submit" class="button" value="Create Game" />

	</form>
</div>