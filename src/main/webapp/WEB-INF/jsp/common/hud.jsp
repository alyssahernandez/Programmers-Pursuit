<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<c:url var = "invitationURL" value="/gameboard/${gameCode}/sendInvitation" />
<c:url var="startGameURL" value="/startGame" />

<div class="hud">
	<c:if test="${outOfQuestions }" ><p>You are out of questions. Game over!</p></c:if>

	<c:if test="${unstartedGame != null}" > 
		<c:forEach var="player" items="${playersInGame}">
			<div>
				<p>${player.name}</p>
			</div>
			
		</c:forEach>
		<form action="${invitationURL}" method="POST">
			<label for="username">Player Name:</label> 
			<input type="text" name="username" />
			<input type="submit" class="button" value="Send Invitation" />
			<c:if test="${invalidUser}">
				<p>User not found: Please enter a valid username</p>
			</c:if>
		</form>
		<c:if test="${unstartedGame.activePlayers.size() >= 2 }" >
		 	<form action="${startGameURL}" method="POST">
				<input type="submit" class="button" value="Start Game" />
				<input type="hidden" name="gameCode" value="${unstartedGame.gameCode}"/>
			</form>
		</c:if>
	</c:if>
<!-- 	MESSAGE SECTION -->
	<div class="hud__message u-center-text">
		<h2 class="hud-message hud-message--primary">
			<c:choose>
				<c:when test="${completedGame != null}">
					<c:out value="${ currentPlayerTurn.name}" />, you won!
				</c:when>
				<c:when test="${earlyEnder != null }">
					<c:out value="This game has ended."/>
				</c:when>
				<c:otherwise>
					<c:if test="${currentGame != null}">
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