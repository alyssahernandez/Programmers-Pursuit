<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:url var="questionFormURL" value="/question/${ currentGame.gameCode }"/>
	<form action="${ questionFormURL }" class="question-form" method="POST">
		<label class="question-form__text" for="question">What is the default direction of contents in a Flex Box?</label>
		<input class="question-form__answer" name="question" type="text" placeholder="Enter your answer here..."/>
		
		<input class="question-form__button" type="submit" value="Submit Answer"/>
	</form>