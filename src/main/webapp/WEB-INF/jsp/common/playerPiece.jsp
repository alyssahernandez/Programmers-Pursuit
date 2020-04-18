<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="playerColor" value="${ currentPlayerTurn.color }"/>

<div class="player-piece u-color${ playerColor }">	
	<c:forEach var="i" begin="1" end="6">			
		
		<c:set var="filled" value=""/>
		<c:set var="piece" value="pie${ i }"/>			
		
		<c:if test="${ currentPlayerTurn[piece] }">
			<c:set var="filled" value="u-color${ i }-alt"/>
		</c:if>		
		
		<div class="player-piece__slice ${ filled }"></div>			
	
	</c:forEach>		
</div>