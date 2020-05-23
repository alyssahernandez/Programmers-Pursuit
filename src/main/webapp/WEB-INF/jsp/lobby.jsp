<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="joinGameURL" value="/joinGame"/>

<h1 class="headers__invites u-margin-bottom-small">Open Lobbies</h1>
<div>	
	<c:forEach var="game" items="${openGames}">
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				Game Code: <c:out value="${game.gameCode }"/><br>
				Capacity: <c:out value="${game.activePlayers.size()}/6"/><br>
				Categories: ${game.uniqueCategories.get(0).categoryName}<c:forEach var="index" begin="1" end="${game.uniqueCategories.size() - 1}">,
				<fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
				${game.uniqueCategories.get(intValue).categoryName}
				</c:forEach>
			</div>
			<div class="invites__buttons">
				<form method="POST" action="${joinGameURL}">
					<input type="submit" class="button--small" value="Join"/>
					<input type="hidden" value="${game.gameCode }" name="gameCode"/>
				</form>	
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />