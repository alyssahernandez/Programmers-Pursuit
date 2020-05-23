<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="createGame" value="common/createGame.jsp"/>
<c:url var="invites" value="common/invitations.jsp"/>
<c:url var="lobbiesURL" value="/lobbies"/>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="profile">
	<h1 class="profile__header headers__profile u-margin-bottom-medium"><c:out value="${currentUser.username }"/>'s Games</h1>
	<div class="profile__content">
	 	<c:import url="${createGame }" />
	 	<div class="profile__content--right">
	 		<form action="${lobbiesURL}" method="GET">
	 			<button class="button u-margin-bottom-small">Game Lobby</button>
	 		</form>
			<c:import url="${invites }" />
	 	</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />