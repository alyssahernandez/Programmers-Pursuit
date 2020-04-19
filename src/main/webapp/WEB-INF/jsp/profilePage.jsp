<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h2>This is the Profile Page</h2>

<p><c:out value="${userid}"></c:out></p>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />