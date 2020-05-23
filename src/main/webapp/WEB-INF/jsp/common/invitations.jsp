<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="joinGameURL" value="/joinGame"/>
<c:url var="rejectGameURL" value="/rejectGame"/>

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