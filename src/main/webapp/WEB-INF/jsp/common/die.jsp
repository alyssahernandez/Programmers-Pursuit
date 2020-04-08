<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="hud__status--die">
<!-- 		TODO JEFF: THE DIE PNGS NEED TO HAVE THEIR COLORS CHANGED OR SWAPPED OUT FOR NEW GRAPHICS -->

<c:url value="/gameboard/${gameCode}" var="dieRollRefresh" />
<form method="GET" action="${dieRollRefresh}">

	<c:choose>
	    <c:when test="${currentPlayerTurn.lastDiceRoll != 0}">
	      <button type="submit" name="isRollingDie" value="true" disabled>Roll Die</button>
	    </c:when>
	    <c:otherwise>
	      <button type="submit" name="isRollingDie" value="true">Roll Die</button>
	    </c:otherwise>
    </c:choose>
 			
</form>
	
	<!-- TODO Jeff:  -->
	<img src="/trivial-pursuit/img/dice${ currentPlayerTurn.lastDiceRoll }.png">
</div>
