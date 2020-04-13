<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div>

<h2><c:out value="Game Options"/></h2>



<c:url var="gameOptionsURL" value="/create"/>

<form action="${gameOptionURL }" method="POST">
	
	<label for="gameCode">Game Code:</label>
	<input type="text" name="gameCode"/>

</form>




<form action="${gameOptionsURL }" method="POST">

	<label for="numberOfPlayers">How Many Players:</label>
	
	<div>
		<label for="playerTwo"></label>
		<input type="text" name="playerTwo" placeholder="Name"/>
		
		<label for="playerThree"></label>
		<input type="text" name="playerThree" placeholder="Name"/>
		
		<label for="playerFour"></label>
		<input type="text" name="playerFour" placeholder="Name"/>
		
		<label for="playerFive"></label>
		<input type="text" name="playerFive" placeholder="Name"/>
		
		<label for="playerSix"></label>
		<input type="text" name="playerSix" placeholder="Name">
		
	</div>
</form>





</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />