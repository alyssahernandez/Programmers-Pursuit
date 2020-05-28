<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="createGameURL" value="/create" />


<div class="create">
  
	<c:if test="${currentUser.username == anyone.username }">
	  <h2 class="headers__create u-center-text u-margin-bottom-small"><c:out value="Create a Game" /></h2>
    
		<form:form class="create__form" action="${createGameURL }" method="POST" modelAttribute="createGame">
		  <h3 class="headers__create-categories">Topics:</h3>
			<c:forEach var="category" items="${categories }">
        
        <div class="create__form-group">
          <form:checkbox path="selectedCategories" class="create__checkbox" id="${category.categoryName }" value="${category.categoryId }" />
          <form:label path="selectedCategories" class="create__label labels__create" for="${category.categoryName }">${category.categoryName }</form:label>
        </div>
                
			</c:forEach>
      
			<form:label path="publicOrPrivate">Access:</form:label>
			<form:select path="publicOrPrivate">
				<form:option value="">Select public or private:</form:option>
				<form:option value="public">Public</form:option>
				<form:option value="private">Private</form:option>
			</form:select>
			<form:errors path="selectedCategories" cssClass="error"/>
			<form:errors path="publicOrPrivate" cssClass="error"/>		
			
			<input type="submit" class="button" value="Start Game!" />
	
		</form:form>
	</c:if>

</div>


