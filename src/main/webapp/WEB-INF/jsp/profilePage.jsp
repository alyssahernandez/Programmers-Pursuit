<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="invites" value="common/invitations.jsp"/>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="profile">
	<h1 class="profile__header headers__profile u-margin-bottom-medium"><c:out value="${currentUser.username }"/>'s Games</h1>
	<div class="profile__content">
		<div class="active-games">ACTIVE GAMES</div>
	 	<div class="profile__content--right">
	 		<c:url var="lobbyURL" value="/lobby"/>
	 		<a class="tile u-margin-bottom-small" href="${ lobbyURL }">Game Lobby</a>
			<c:import url="${invites }" />
	 	</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />