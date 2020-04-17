<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="die">
	<button class="button" id="rollDie">
		Roll the Die
	</button>
	
	<c:set var="currentDieRoll" value="${ currentGame.activePlayerRoll }"/>
	<img id="dieImg" src="/trivial-pursuit/img/dice${ currentDieRoll }.png">
</div>
