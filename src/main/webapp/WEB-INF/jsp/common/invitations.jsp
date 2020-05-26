<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="joinGameURL" value="/joinGame"/>
<div class="invites">	
	<h3 class="headers__invites u-margin-bottom-small">Invitations</h3>
	<c:forEach var="invitation" items="${invitations }">
		<div class="invites__invite u-margin-bottom-small">
			<div class="invites__details u-margin-bottom-small">
				Game Code: <c:out value="${invitation.gameCode }"/><br>
				Invited By: <c:out value="${invitation.invitedBy }"/>
			</div>
			<div class="invites__buttons">
				<form method="POST" action="${joinGameURL}">
					<input type="submit" class="button--small u-button-green" value="Accept"/>
					<input type="hidden" value="${invitation.gameCode }" name="gameCode"/>
				</form>
				
<!-- 			JEFF: THIS BUTTON NEEDS CONFIGURING -->
				<form method="POST" action="${rejectGameURL}">
					<input type="submit" class="button--small u-button-red" value="Reject"/>
					<input type="hidden" value="${invitation.gameCode }" name="gameCode"/>
				</form>			
			</div>
		</div>
	</c:forEach>
</div>