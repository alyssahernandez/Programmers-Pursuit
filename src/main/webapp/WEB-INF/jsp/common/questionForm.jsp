<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="questionFormURL" value="/question/${ currentGame.gameCode }"/>

<div class="question">
	<c:choose>
		<c:when test="${currentPlayerSpace.center }">
			<c:choose>		
				<c:when test="${chosenCenterSpaceCategory eq 'false' }">			
					<form action="${questionFormURL }" method="POST" class="question-form">				
						<c:forEach var="cat" items="${hashedCategories }">
							<label class="question-form_text" for="category">
							<input type="radio" name="categoryChoiceId" value="${cat.categoryId }">${cat.categoryName }</label>
						</c:forEach>
						<input type="hidden" name="hasChosenCenterSpaceCategory" value="true" />
						<input type="submit" value="Submit"/>					
					</form>			
				</c:when>		
				<c:otherwise>			
					<form action="${ questionFormURL }" class="question-form" method="POST">
						<label class="question-form__text" for="answer">${question.question }</label>
						<input class="question-form__answer" name="answer" type="text" placeholder="Enter your answer here..."/>
						
						<input class="question-form__button" type="submit" value="Submit Answer"/>
					</form>			
				</c:otherwise>		
			</c:choose>	
		</c:when>	
		<c:otherwise>	
			<form action="${ questionFormURL }" class="question-form" method="POST">
				<label class="question-form__text" for="answer">${question.question }</label>
				<input class="question-form__answer" name="answer" type="text" placeholder="Enter your answer here..."/>					
				<input class="question-form__button" type="submit" value="Submit Answer"/>
			</form>	
		</c:otherwise>	
	</c:choose>
</div>
