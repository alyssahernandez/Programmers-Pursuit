<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="stylesheetHref" value="/css/main.css" />
<link rel="stylesheet" href="${stylesheetHref}">

<c:if test="${currentUser.username == anyone.username }">
	<div class="invites">	
		<h3 class="headers__invites u-margin-bottom-small">Friends</h3>
		<c:forEach var="user" items="${currentUser.friends }">
			<c:url var="userProfileURL" value="/profile/${user.username}"/>
			<c:url var="profilePicURL" value="${user.picture }"/>
			<div class="invites__invite u-margin-bottom-small">
				<div>
					<img width="30" height="30" src="${ profilePicURL }">
					<c:out value="${user.username}"/><br>
				</div>
				<div class="invites__buttons">
					<form action="${userProfileURL }" method="GET">
						<input type="submit" value="View Profile" />
					</form>	
				</div>
			</div>
		</c:forEach>
	</div>
	<br>
	<div class="invites">
		<h3 class="headers__invites u-margin-bottom-small">Pending Requests</h3>
		<c:forEach var="user" items="${currentUser.pendingFriendRequests }">
			<c:url var="userProfileURL" value="/profile/${user.username}"/>
			<c:url var="profilePicURL" value="${user.picture }"/>
			<div class="invites__invite u-margin-bottom-small">
				<div>
					<img width="50" height="50" src="${ profilePicURL }">
					<c:out value="${user.username}"/><br>
				</div>
				<div class="invites__buttons">
					<form action="${userProfileURL }" method="GET">
						<input type="submit" value="View Profile" />
					</form>	
				</div>		
			</div>
		</c:forEach>
	</div>
	<br>
		<div class="invites">
		<h3 class="headers__invites u-margin-bottom-small">Incoming Requests</h3>
		<c:forEach var="user" items="${currentUser.incomingFriendRequests }">
			<c:url var="userProfileURL" value="/profile/${user.username}"/>
			<c:url var="profilePicURL" value="${user.picture }"/>
			<c:url var="acceptFriendURL" value="/acceptFriendRequest"/>
			<c:url var="rejectFriendURL" value="/rejectFriendRequest"/>
			<div class="invites__invite u-margin-bottom-small">
				<div>
					<img width="50" height="50" src="${ profilePicURL }">
					<c:out value="${user.username}"/><br>
				</div>
				<div class="invites__buttons">
					<form action="${acceptFriendURL }" method="POST">
						<input type="hidden" value="${user.username }" name="username"/>
						<input type="submit" value="Accept" />
					</form>	
					<form action="${rejectFriendURL }" method="POST">
						<input type="hidden" value="${user.username }" name="username"/>
						<input type="submit" value="Reject" />
					</form>	
					<form action="${userProfileURL }" method="GET">
						<input type="submit" value="View Profile" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>