<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="joinGameURL" value="/joinGame"/>
<div>
	
	<c:forEach var="invitation" items="${invitations }">
		<div id="invite">
			<p>${invitation.gameCode }</p>
			<p>${invitation.invitee }</p>
			<p>${invitation.invitedBy }</p>
		
			<form method="POST" action="${joinGameURL}">
				<input type="submit" class="button" value="Join Game"/>
				<input type="hidden" value="${invitation.gameCode }" name="gameCode"/>
			</form>	
		</div>
	</c:forEach>

</div>