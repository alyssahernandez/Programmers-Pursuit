<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!-- div for displaying search game/create game options -->
<div>
	<h4>Please enter an active game code to join:</h4>
	<c:url var="mainMenuURL" value="/"/>
	<form action="${mainMenuURL }" method="POST">
		<label for="gameSearch"></label>
		<input name="gameSearch" type="text" placeholder="Enter Game Code..." />

		<label for="search"></label>
		<input name="search" type="submit" value="Search" />
	</form>
</div>

<!-- 	TODO: THIS FORM NEEDS CONFIGURING - JEFF -->
<div>
	<h4>Or please fill in the fields below to create a game:</h4>
	
	<c:url var="createGameURL" value="/create"/>
	<form action="${createGameURL }" method="GET" >
	
	<input type="submit" value="Create Game"/>
	
	</form>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

<!--  <header class="header"> -->
<!--                 <div class="header__video"> -->
<!--                     <video class="header__video-content" autoplay muted loop> -->
<!--                         <source src="img/hero.mp4" type="video/mp4"> -->
<!--                         <source src="img/hero.webm" type="video/webm"> -->
<!--                         Your browser is not supported! -->
<!--                     </video> -->
<!--                 </div> -->
<!--                 <div class="header__titles"> -->
<!--                     <h1 class="heading-1">Jeff and Erin's Music Swap 2019</h1> -->
<!--                     <h2 class="heading-2">We've been sharing music with each other!</h2> -->
<!--                 </div> -->
<!--             </header> -->

<!-- .header { -->
<!--     height: 100vh; -->
<!--     position: relative; -->
<!--     background-image: linear-gradient( -->
<!--         to right bottom, -->
<!--          rgba(#000, 1), -->
<!--          rgba(#000, 1)); -->
<!--     display: grid; -->
<!--     align-content: center; -->
<!--     justify-content: center; -->

<!--     &__titles { -->
<!--         max-width: 80vw; -->
<!--     } -->

<!--     &__video { -->
<!--         position: absolute; -->
<!--         top: 0; -->
<!--         left: 0; -->
<!--         height: 100%; -->
<!--         width: auto; -->
<!--         overflow: hidden; -->
<!--         opacity: .25; -->
<!--     } -->

<!--     &__video-content { -->
<!--         height: 100%; -->
<!--         width: 100%; -->
<!--         object-fit: cover; -->
<!--     } -->
<!-- }  -->