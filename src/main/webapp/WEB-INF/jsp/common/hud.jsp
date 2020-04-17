<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<div class="hud">
	<div class="hud__message u-center-text">	
		<c:choose>			
			<c:when test="${currentPlayerTurn.allPies }">	
				<h2 class="hud-message"><c:out value="${ currentPlayerTurn.name }"/>, you won!<br>Congratulations.</h2>
			</c:when>
			<c:otherwise>			
				<c:choose>
					<c:when test="${currentPlayerTurn.diceRoll == 0 }" >
						<h2 class="hud-message"><c:out value="${ currentPlayerTurn.name }"/>, it's your turn.<br>Roll the die.</h2>		
					</c:when>
					<c:otherwise>
						<h2 class="hud-message"><c:out value="${ currentPlayerTurn.name }"/>, you rolled a <c:out value="${ currentPlayerTurn.diceRoll }"/>.<br>Where do you want to move?</h2>
					</c:otherwise>
				</c:choose>				
			</c:otherwise>			
		</c:choose>		
	</div>

	<div class="hud__status">		
		<c:import url="${ pieceURL }" />		
		<c:if test="${!currentPlayerTurn.allPies }">
			<c:import url="${ dieURL }" />	
		</c:if>			
	</div>

	<c:import url="${ legendURL }" />

</div>