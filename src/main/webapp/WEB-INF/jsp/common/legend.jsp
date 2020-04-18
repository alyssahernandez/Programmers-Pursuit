<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="legend">
	<c:set var="i" value="1"/>
	<c:forEach var="category" items="${ gameCategories }">
		<div class="legend--row">
			<div class="legend--color u-color${ i }"></div>
			<div class="legend--category"><c:out value="${ category.categoryName }"/></div>
		</div>
		<c:set var="i" value="${ i + 1 }"/>
	</c:forEach>
</div>