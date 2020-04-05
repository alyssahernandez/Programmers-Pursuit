<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="hud__status--piece">

	<c:set var="playerColor" value="${ currentPlayerTurn.color }"/>
	


	<div class="player-piece cat${ playerColor }">	
		<c:forEach var="i" begin="1" end="6">
			
			<c:set var="filled" value=""/>
			
			<c:if test="">
				<c:set var="filled" value="cat${ i }"/>
			</c:if>
		
			<div class="player-piece__slice ${ filled }"></div>			
		</c:forEach>		
	</div>
</div>