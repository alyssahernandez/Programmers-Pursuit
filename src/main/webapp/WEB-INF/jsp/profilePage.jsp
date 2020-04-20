<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h2>This is the Profile Page</h2>
<<<<<<< HEAD
<div>
	<h3>this is the access Id: ${userId}</h3>
	<h3>this is the email: ${userInfo }</h3>
</div>
=======
<h2>${userId}</h2>

<p><c:out value="${userid}"></c:out></p>


>>>>>>> 4d926515d2adfe678961bb2f7ef8085bcace53fa

<c:import url="/WEB-INF/jsp/common/footer.jsp" />