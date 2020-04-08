<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="hud__legend">
	<c:set var="i" value="1"/>
	<c:forEach var="category" items="${ gameCategories }">
		<div class="hud__legend--row">
			<div class="hud__legend--color cat${ i }"></div>
			<div class="hud__legend--category"><c:out value="${ category.categoryName }"/></div>
		</div>
		<c:set var="i" value="${ i + 1 }"/>
	</c:forEach>
</div>