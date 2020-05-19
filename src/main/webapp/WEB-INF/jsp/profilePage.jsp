<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="createGame" value="common/createGame.jsp"/>
<c:url var="invites" value="common/invitations.jsp"/>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h2>This is the Profile Page</h2>

<div>
	<h3>this is the Nickname: ${currentUser.username }</h3>
	<h3>this is the email: ${currentUser.email }</h3>
	<img src="<c:url value="${currentUser.picture }"/>">
	
	<c:import url="${invites }" />
	
 	<c:import url="${createGame }" />

	
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />