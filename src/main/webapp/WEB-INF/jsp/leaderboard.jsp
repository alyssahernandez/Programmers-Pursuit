<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1 class="headers__invites u-margin-bottom-small">Open Lobbies</h1>
<div>	
	<c:forEach var="user" items="${leaders}">
		<c:url var="userProfileURL" value="/profile/${user.username}"/>
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				<img width="30" height="30" src="${ profilePicURL }">
				<c:out value="${user.username}"/><br>
				<c:out value="Games Won: ${user.gamesWon}"/><br>
				<c:out value="Games Played: ${user.gamesPlayed}"/><br>
				<form action="${userProfileURL }" method="GET">
					<input type="submit" value="View Profile" />
				</form>	
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />