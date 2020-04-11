<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="hud__status--die">
<!-- 		TODO JEFF: THE DIE PNGS NEED TO HAVE THEIR COLORS CHANGED OR SWAPPED OUT FOR NEW GRAPHICS -->

	<button id="rollDie">
		Roll the Die
	</button>
	
	
	<c:set var="currentDieRoll" value="${ currentGame.activePlayerRoll }"/>
	<img id="dieImg" src="/trivial-pursuit/img/dice${ currentDieRoll }.png">

</div>
