<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<div class="hud">

<!-- 	MESSAGE SECTION -->
	<div class="hud__message u-center-text">
		<h2 class="hud-message hud-message--primary">
			<c:choose>
				<c:when test="${ currentPlayerTurn.allPies }">
					<c:out value="${ currentPlayerTurn.name }" />, you won!
				</c:when>
				<c:otherwise>
					<c:out value="${ currentPlayerTurn.name }" />, it's your turn.
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