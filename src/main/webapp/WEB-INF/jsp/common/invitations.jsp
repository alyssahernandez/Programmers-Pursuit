<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="joinGameURL" value="/joinGame"/>
<c:url var="rejectGameURL" value="/rejectGame"/>
<c:url var="addFriendURL" value="/addFriend"/>
<c:url var="removeFriendURL" value="/removeFriend"/>
<c:url var="cancelRequestURL" value="/cancelFriendRequest"/>

<c:if test="${currentUser.username == anyone.username }">
	<div class="invites">	
		<h3 class="headers__invites u-margin-bottom-small">Invitations</h3>
		<c:forEach var="invitation" items="${invitations }">
			<div class="invites__invite u-margin-bottom-small">
				<div class="invites__details u-margin-bottom-small">
					Game Code: <c:out value="${invitation.gameCode }"/><br>
					Invited By: <c:out value="${invitation.invitedBy }"/><br>
					Categories: ${pairs.get(invitation).get(0).categoryName}<c:forEach var="index" begin="1" end="${pairs.get(invitation).size() - 1}">,
					<fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
					${pairs.get(invitation).get(intValue).categoryName}
					</c:forEach>
				</div>
				<div class="invites__buttons">
					<form method="POST" action="${joinGameURL}">
						<input type="submit" class="button--small" value="Accept"/>
						<input type="hidden" value="${invitation.gameCode }" name="gameCode"/>
					</form>
					
					<form method="POST" action="${rejectGameURL}">
						<input type="submit" class="button--small" value="Reject"/>
						<input type="hidden" value="${invitation.gameCode }" name="gameCode"/>
					</form>			
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>

<c:choose>
	<c:when test="${currentUser.username != anyone.username && !currentUser.friends.contains(anyone) && !currentUser.pendingFriendRequests.contains(anyone)}">
		<form action="${addFriendURL }" method="POST">
			<input type="hidden" name="username" value="${anyone.username }"/>
			<input type="submit" class="button" value="Add Friend" />
		</form>
	</c:when>
	<c:when test="${currentUser.username != anyone.username && !currentUser.friends.contains(anyone)}">
		<form action="${cancelRequestURL }" method="POST">
			<input type="hidden" name="username" value="${anyone.username }"/>
			<input type="submit" class="button" value="Cancel Friend Request" />
		</form>
	</c:when>
	<c:when test="${currentUser.username != anyone.username && !currentUser.pendingFriendRequests.contains(anyone)}">
		<form action="${removeFriendURL }" method="POST">
			<input type="hidden" name="username" value="${anyone.username }"/>
			<input type="submit" class="button" value="Remove Friend" />
		</form>
	</c:when>
</c:choose>

