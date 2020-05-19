<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
	
	<c:forEach var="invitation" items="${invitations }">
		<div id="invite">
			<p>${invitation.gameId}</p>
			<p>${invitation.invitee }</p>
			<p>${invitation.invitedBy }</p>
		</div>
	</c:forEach>

</div>