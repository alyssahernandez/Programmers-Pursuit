<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h2>This is the Profile Page</h2>

<div>
	<h3>this is the access Id: ${body}</h3>
	<h3>this is the idToken: ${userInfo }</h3>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />