<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="die">
	
	<!-- @Jeff, if it's easier for styling, we could move the pair of "if"s to hud.jsp around the line(s) where this file is imported -->
	<c:if test="${currentGame.active }" >
		<c:if test="${currentUser.username == currentPlayerTurn.name }">
			<button class="button" id="rollDie">
				Roll the Die
			</button>
			
			<c:set var="currentDieRoll" value="${ currentGame.activePlayerRoll }"/>
			<img id="dieImg" src="/trivial-pursuit/img/dice${ currentDieRoll }.png">
		</c:if>
	</c:if>
</div>
