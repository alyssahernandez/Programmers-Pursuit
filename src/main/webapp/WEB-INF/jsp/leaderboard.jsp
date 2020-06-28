<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Leaderboard</h1>
<div>
	<h3>All-Time</h3>
	<c:forEach var="user" items="${allTimeleaders}">
		<c:url var="userProfileURL" value="/profile/${user.username}"/>
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				<img width="30" height="30" src="${ profilePicURL }">
				<c:out value="${user.username}"/><br>
				<c:out value="Games Won: ${user.gamesWon}"/><br>
				<form action="${userProfileURL }" method="GET">
					<input type="submit" value="View Profile" />
				</form>	
			</div>
		</div>
	</c:forEach>
</div>
<div>
	<h3>Monthly</h3>
	<c:forEach var="user" items="${monthlyLeaders}">
		<c:url var="userProfileURL" value="/profile/${user.username}"/>
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				<img width="30" height="30" src="${ profilePicURL }">
				<c:out value="${user.username}"/><br>
				<c:out value="Games Won: ${user.gamesWon}"/><br>
				<form action="${userProfileURL }" method="GET">
					<input type="submit" value="View Profile" />
				</form>	
			</div>
		</div>
	</c:forEach>
</div>
<div>
	<h3>Daily</h3>
	<c:forEach var="user" items="${dailyLeaders}">
		<c:url var="userProfileURL" value="/profile/${user.username}"/>
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				<img width="30" height="30" src="${ profilePicURL }">
				<c:out value="${user.username}"/><br>
				<c:out value="Games Won: ${user.gamesWon}"/><br>
				<form action="${userProfileURL }" method="GET">
					<input type="submit" value="View Profile" />
				</form>	
			</div>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />