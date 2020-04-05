<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="hud__legend">
	<c:forEach var="category" items="${ gameCategories }">
		<div class="hud__legend--row">
			<div class="hud__legend--color cat${ category.categoryId }"></div>
			<div class="hud__legend--category"><c:out value="${ category.categoryName }"/></div>
		</div>
	</c:forEach>
</div>