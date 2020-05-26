<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<c:url var = "invitationURL" value="${gameCode}/sendInvitation" />
<c:url var="startGameURL" value="/startGame" />

<div class="hud">

	<c:if test="${!(currentGame.active) && currentGame.winnerId == 0}" > 
		<c:forEach var="player" items="${playersInGame}">
			<div>
				<p>${player.name}</p>
			</div>
			
		</c:forEach>
		<form action="${invitationURL}" method="POST">
			<label for="username">Player Name:</label> 
			<input type="text" name="username" />
			<input type="submit" class="button" value="Send Invitation" />
		</form>
		<c:if test="${currentGame.activePlayers.size() >= 2 }" >
		 	<form action="${startGameURL}" method="POST">
				<input type="submit" class="button" value="Start Game" />
				<input type="hidden" name="gameCode" value="${currentGame.gameCode}"/>
			</form>
		</c:if>
	</c:if>
<!-- 	MESSAGE SECTION -->
	<div class="hud__message u-center-text">
		<h2 class="hud-message hud-message--primary">
			<c:choose>
				<c:when test="${ currentPlayerTurn.allPies && !currentGame.active}">
					<c:out value="${ currentPlayerTurn.name}" />, you won!
				</c:when>
				<c:otherwise>
					<c:if test="${currentGame.active }">
						<c:out value="${ currentPlayerTurn.name}" />, it's your turn.
					</c:if>
				</c:otherwise>
			</c:choose>
		</h2>

		<h2 class="hud-message hud-message--rolled">
			<c:out value="${ currentPlayerTurn.name }" />, you rolled a <c:out value="${ currentPlayerTurn.diceRoll }"/>.<br>Where do you want to move?
		</h2>
	</div>

<!-- 	STATUS SECTION -->
	<div class="hud__status">
		<c:import url="${ pieceURL }" />	
		<c:if test="${ questionHUD }">	
			<c:import url="${ dieURL }" />
		</c:if>	
	</div>

<!-- LEGEND SECTION -->
	<c:if test="${ questionHUD }">
		<c:import url="${ legendURL }" />
	</c:if>
	

</div>