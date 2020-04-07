<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "headerURL" value="common/header.jsp" />
<c:url var = "questionFormURL" value="common/questionForm.jsp" />
<c:url var = "pieceURL" value="common/playerPiece.jsp" />
<c:url var = "dieURL" value="common/die.jsp" />
<c:url var = "legendURL" value="common/legend.jsp" />

<c:import url="${ headerURL }" />

<div class="gameboard">
	<c:import url="${ questionFormURL }" />
</div>

<div class="hud">
<!-- 	THIS IS WHERE THE CURRENT PLAYER INSTRUCTIONS WILL GO -->
	<div class="hud__message">
		<h2><c:out value="${ currentPlayerTurn.name }"/>, please answer the question on the left</h2>
	</div>

<!-- 		THIS SECTION HAS BOTH THE CURRENT DIE ROLL AND A PICTURE OF THE CURRENT PLAYER'S FULL SCORE STATUS -->
	<div class="hud__status">		
		<c:import url="${ pieceURL }" />
	</div>

<!-- 	THIS IS THE LEGEND SECTION -->
	<c:import url="${ legendURL }" />
</div>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
		