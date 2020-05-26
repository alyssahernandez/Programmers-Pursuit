<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="createGame" value="common/createGame.jsp"/>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="lobby">
	<div class="games">
		<div class="games__available">AVAILABLE GAMES</div>
		<div class="games__pending">PENDING GAMES</div>
	</div>
	<c:import url="${ createGame }" />
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />