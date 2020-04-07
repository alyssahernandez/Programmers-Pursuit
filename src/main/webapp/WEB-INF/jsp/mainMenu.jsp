<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!-- div for displaying search game/create game options -->
<div>

	<h4>Please enter an active game code to join:</h4>
	<c:url var="mainMenuURL" value="/"/>
	<form action="${mainMenuURL }" method="POST">
		<label for="gameSearch"></label>
		<input name="gameSearch" type="text" placeholder="Enter Game Code..." />

		<label for="search"></label>
		<input name="search" type="submit" value="Search" />
	</form>
</div>

<!-- 	TODO: THIS FORM NEEDS CONFIGURING - JEFF -->
<div>
	<h4>Or please fill in the fields below to create a game:</h4>
	
	<c:url var="createGame" value="/create"/>
	<form action="${createGame }" method="GET" >
	
	<input type="submit" value="Create Game"/>
	
	</form>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />