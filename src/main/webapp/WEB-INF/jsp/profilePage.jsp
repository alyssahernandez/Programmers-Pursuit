<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h2>This is the Profile Page</h2>

<div>
	<h3>this is the Nickname: ${currentUser.username }</h3>
	<h3>this is the email: ${currentUser.email }</h3>
	<img src="<c:url value="${currentUser.picture }"/>">
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />