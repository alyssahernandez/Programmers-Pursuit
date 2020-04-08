<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "headerURL" value="common/header.jsp" />
<c:url var = "boardURL" value="common/board.jsp" />
<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<c:import url="${ headerURL }" />

<div class="gameboard">
	<c:import url="${ boardURL }" />
</div>

<div class="hud">
<!-- 	THIS IS WHERE THE CURRENT PLAYER INSTRUCTIONS WILL GO -->
	<div class="hud__message">
	
		<c:choose>
			<c:when test="${currentPlayerTurn.lastDiceRoll == 0 }" >
				<h2><c:out value="${ currentPlayerTurn.name }"/>, it's your turn.<br>Roll the die.</h2>		
			</c:when>
			<c:otherwise>
				<h2><c:out value="${ currentPlayerTurn.name }"/>, you rolled a <c:out value="${ currentPlayerTurn.lastDiceRoll }"/>.<br>Where do you want to move?</h2>
			</c:otherwise>
		</c:choose>
	</div>
	
	<!-- THIS IS A TEMPORARY PLACEMENT FOR THE CHOOSING A SPACE FORM. THIS IS NOT WHERE
	IT WILL LIVE - JUST TESTING FOR FUNCTIONALITY -->
	<div>
		
		<c:choose>
		    <c:when test="${choosingSpace == true}">
		      <button type="submit" form="formForSpaceChoice">Choose Space</button>
		    </c:when>
		    <c:otherwise>
		      <button type="submit" form="formForSpaceChoice" disabled>Choose Space</button>
		    </c:otherwise>
   		</c:choose>
	
	</div>

<!-- 		THIS SECTION HAS BOTH THE CURRENT DIE ROLL AND A PICTURE OF THE CURRENT PLAYER'S FULL SCORE STATUS -->
	<div class="hud__status">		
		<c:import url="${ pieceURL }" />
		<c:import url="${ dieURL }" />		
	</div>

<!-- 	THIS IS THE LEGEND SECTION -->
	<c:import url="${ legendURL }" />
</div>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
		