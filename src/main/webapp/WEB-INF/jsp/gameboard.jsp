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
		<h2>Player 5, it's your turn.<br>Where do you want to move?</h2>
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
		