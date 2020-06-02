<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="questionFormURL" value="/question/${ currentGame.gameCode }"/>

<div class="question">
	<c:choose>
		<c:when test="${currentPlayerSpace.center }">		
			<c:choose>		
				<c:when test="${currentGame.hasActivePlayerSelectedCategory eq false }">				
					<form action="${questionFormURL }" method="POST" class="question-form">		
						<c:choose>
							<c:when test="${currentPlayerTurn.allPies eq true }">						
								<h3 class="question-form__question u-margin-bottom-medium"><c:out value="Congrats, ${currentPlayerTurn.name }. All other players: Choose a category for ${currentPlayerTurn.name }'s chance to win." /></h3>							
							</c:when>
							<c:otherwise>						
								<h3 class="question-form__question u-margin-bottom-medium"><c:out value="${currentPlayerTurn.name }, choose a category." /></h3>							
							</c:otherwise>
						</c:choose>
						<div class="question-form__answers u-margin-bottom-medium">		
							<c:forEach var="cat" items="${gameCategories }">
								<div class="question-form__group u-margin-bottom-small">
									<input class="question-form__radio" name="categoryChoiceId" type="radio" id="${ cat.categoryName }" value="${ cat.categoryId }">
									<label class="question-form__label" for="${ cat.categoryName }">${ cat.categoryName }</label>
								</div>							
							</c:forEach>
						</div>
						<input type="hidden" name="chosenCenterSpaceCategory" value="true" />
						<input class="button" type="submit" value="Submit"/>					
					</form>	
				</c:when>		
				<c:otherwise>					
					<form action="${ questionFormURL }" method="POST" class="question-form">
						<h3 class="question-form__question u-margin-bottom-medium">${ question.question }</h3>
						<div class="question-form__answers u-margin-bottom-medium">
							<c:forEach var="answer" items="${possibleAnswers}">
								<div class="question-form__group u-margin-bottom-small">
									<input class="question-form__radio" name="answer" type="radio" id="${ answer }" value="${ answer }">
									<label class="question-form__label" for="${ answer }">${ answer }</label>
								</div>
							</c:forEach>
						</div>
						<c:if test="${currentUser.username == currentPlayerTurn.name }">
							<input class="button" type="submit" value="Submit"/>
						</c:if>
					</form>
						
					<!-- TODO: @Jeff: styling for the answers - left this commented out for reference.
					the other question form below is the form for answers - just in two places for
					conditional logic purposes - lmk if you have questions - ALYSSA
					
					<form action="${ questionFormURL }" method="POST" class="question-form">
						<label class="question-form__text" for="answer">${question.question }</label>
						<input class="question-form__answer" name="answer" type="text" placeholder="Enter your answer here..."/>						
						<input class="question-form__button" type="submit" value="Submit Answer"/>
					</form>
						
					 -->
					 
				</c:otherwise>		
			</c:choose>	
		</c:when>	
		<c:otherwise>	
			<form action="${ questionFormURL }" method="POST" class="question-form">
				<h3 class="question-form__question u-margin-bottom-medium">${ question.question }</h3>
				<div class="question-form__answers u-margin-bottom-medium">
					<c:forEach var="answer" items="${ possibleAnswers }">
						<div class="question-form__group u-margin-bottom-small">
							<input class="question-form__radio" name="answer" type="radio" id="${ answer }" value="${ answer }">
							<label class="question-form__label" for="${ answer }">${ answer }</label>
						</div>
					</c:forEach>
				</div>
				<c:if test="${currentUser.username == currentPlayerTurn.name }">
					<input class="button" type="submit" value="Submit"/>
				</c:if>
			</form>
		</c:otherwise>	
	</c:choose>
</div>
