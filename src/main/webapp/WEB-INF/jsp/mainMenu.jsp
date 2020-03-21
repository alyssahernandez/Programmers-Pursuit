<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div>
	<c:url var="mainMenuURL" value="/"/>
	<form action="${mainMenuURL }" method="GET">
		<label for="gameSearch"></label>
		<input name="gameSearch" type="text" placeholder="Enter Game Code..." />
		
		<label for="search"></label>
		<input name="search" type="submit" value="Search" />
	</form>
	
	<form action="${mainMenuURL }" method="POST">
		<label for="createGame"></label>
		<input name="createGame" type="submit" value="Create" />
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />