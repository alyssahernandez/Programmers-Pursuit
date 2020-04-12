<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="registerUrl" value="/register" />
<form:form action="${registerUrl }" method="POST" modelAttribute="user">

	<div class="form-group">
	<label for="username">Username</label>
	<form:input class="form-control" path="username" placeholder="Username" />
	<form:errors path="username" cssClass="bg-danger" />
	</div>
	
	<div class="form-group">
	<label for="password">Password</label>
	<form:password class="form-control" path="password"/>
	<form:errors path="password" cssClass="bg-danger" />
	</div>
	
	<div class="form-group">
	<label for="confirmPassword">Confirm Password</label>
	<form:password class="form-control" path="confirmPassword"/>
	<form:errors path="passwordMatching" cssClass="bg-danger" />
	</div>

    
	<button type="submit" class="btn btn-default">Save User</button>
</form:form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />