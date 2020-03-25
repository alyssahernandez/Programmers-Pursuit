<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="gameboard">

<!-- THIS SECTION GENERATES THE OUTER RING OF SPACES WITH THE CORRECT INDEXES -->
	<div class="gameboard__ring">				
		<c:forEach var="i" begin="1" end="6">
			<c:set var="begin" value="${ ((i * 2) - 1) * 6 }"/>
			<c:forEach var="j" begin="${ begin }" end="${ begin + 6 }">
		
				<c:set var="spaceId" value="${ j }"/>
				
				<c:set var="isNode" value=""/>
				<c:if test="${ (j - 6) % 12 == 0 }">
					<c:set var="isNode" value="space__node"/>
				</c:if>
				
<!--  THIS SECTION CREATES THE COLORS ON THE OUTER RING  -->
				<c:set var="category" value=""/>

				<c:choose>				
					<c:when test="${ j == 6 || j == 22 || j == 36 || j == 43 || j == 57 }">
						<c:set var="category" value="cat1"/>
					</c:when>
					<c:when test="${ j == 18 || j == 34 || j == 48 || j == 55 || j == 69 }">
						<c:set var="category" value="cat2"/>
					</c:when>
					<c:when test="${ j == 30 || j == 46 || j == 60 || j == 67 || j == 9 }">
						<c:set var="category" value="cat3"/>
					</c:when>
					<c:when test="${ j == 42 || j == 58 || j == 72 || j == 7 || j == 21 }">
						<c:set var="category" value="cat4"/>
					</c:when>
					<c:when test="${ j == 54 || j == 70 || j == 12 || j == 19 || j == 33 }">
						<c:set var="category" value="cat5"/>
					</c:when>
					<c:when test="${ j == 66 || j == 10 || j == 24 || j == 31 || j == 45 }">
						<c:set var="category" value="cat6"/>
					</c:when>
					<c:otherwise>
						<c:set var="category" value="catRollAgain"/>
					</c:otherwise>
				</c:choose>


<!-- 					JEFF: TODO THIS IS DUMMY CODE FOR STYLISTIC PURPOSES; FIGURE OUT HOW TO TEST FOR REACHABILITY -->
				<c:set var="reachable" value=""/>
				<c:if test="${ j == 18 }">
					<c:set var="reachable" value="space__reachable"/>
				</c:if>

<!-- 				THIS ACTUALLY CREATES THE SPACE AS WELL AS ANY PLAYER TOKENS -->
				<div class="space ${ isNode } ${ category } ${ reachable }" id="${ spaceId }">
					<c:if test="${ j == 10 }">
						<div class="player-piece--small cat2"></div>
						<div class="player-piece--small cat3"></div>
					</c:if>
				</div>
		
			</c:forEach>
		</c:forEach>
	</div>

<!-- THIS SECTION GENERATES THE INNER RING OF "SPOKES" -->
	<div class="gameboard__spokes">					
		<c:forEach var="i" begin="1" end="6">						
			<div class="gameboard__spokes--spoke">
				
				<c:set var="firstSpaceId" value="${ ((i - 1) * 12) + 1 }"/>
				
				<c:forEach var="j" begin="${ firstSpaceId }" end="${ firstSpaceId + 4 }">
				
				<!--  THIS SECTION CREATES THE COLORS ON THE INNER RING  -->
				<c:set var="category" value=""/>
				
				<c:choose>				
					<c:when test="${ j == 13 || j == 28 || j == 41 || j == 51 || j == 62 }">
						<c:set var="category" value="cat1"/>
					</c:when>
					<c:when test="${ j == 25 || j == 40 || j == 53 || j == 63 || j == 2 }">
						<c:set var="category" value="cat2"/>
					</c:when>
					<c:when test="${ j == 37 || j == 52 || j == 65 || j == 3 || j == 14 }">
						<c:set var="category" value="cat3"/>
					</c:when>
					<c:when test="${ j == 49 || j == 64 || j == 5 || j == 15 || j == 26 }">
						<c:set var="category" value="cat4"/>
					</c:when>
					<c:when test="${ j == 61 || j == 4 || j == 17 || j == 27 || j == 38 }">
						<c:set var="category" value="cat5"/>
					</c:when>
					<c:when test="${ j == 1 || j == 16 || j == 29 || j == 39 || j == 50 }">
						<c:set var="category" value="cat6"/>
					</c:when>
				</c:choose>
				
					<div class="space space__spoke-space ${ category }">
						<c:if test="${ j == 15 }">
							<div class="player-piece--small cat1"></div>
						</c:if>
					</div>	
				</c:forEach>
			
			</div>						
		</c:forEach>					
	</div>
	
<!-- THIS IS THE CENTER SPACE -->
	<div class="gameboard__center space space__reachable" id="0"></div>

</div>
<div class="hud">

<!-- 	THIS IS WHERE THE CURRENT PLAYER INSTRUCTIONS WILL GO -->
	<div class="hud__message">
		<h2>Player 5, it's your turn.<br>Where do you want to move?</h2>
	</div>

<!-- 		THIS SECTION HAS BOTH THE CURRENT DIE ROLL AND A PICTURE OF THE CURRENT PLAYER'S FULL SCORE STATUS -->
	<div class="hud__status">
		<div class="hud__status--piece">
			<div class="player-piece cat1">
				<div class="player-piece__slice cat1"></div>
				<div class="player-piece__slice"></div>
				<div class="player-piece__slice cat3"></div>
				<div class="player-piece__slice cat4"></div>
				<div class="player-piece__slice"></div>
				<div class="player-piece__slice"></div>
			</div>
		</div>
		<div class="hud__status--die">
<!-- 		TODO JEFF: THE DIE PNGS NEED TO HAVE THEIR COLORS CHANGED OR SWAPPED OUT FOR NEW GRAPHICS -->
			<img src="/trivial-pursuit/img/dice3.png">
		</div>
	</div>

<!-- 	THIS IS THE LEGEND SECTION -->
	<div class="hud__legend">
		<div class="hud__legend--row">
			<div class="hud__legend--color cat1"></div>
			<div class="hud__legend--category">OOP</div>
		</div>
		<div class="hud__legend--row">
			<div class="hud__legend--color cat2"></div>
			<div class="hud__legend--category">Databases</div>
		</div>
		<div class="hud__legend--row">
			<div class="hud__legend--color cat3"></div>
			<div class="hud__legend--category">Layout/CSS</div>
		</div>
		<div class="hud__legend--row">
			<div class="hud__legend--color cat4"></div>
			<div class="hud__legend--category">Server Side Programming</div>
		</div>
		<div class="hud__legend--row">
			<div class="hud__legend--color cat5"></div>
			<div class="hud__legend--category">Client Side Programming</div>
		</div>
		<div class="hud__legend--row">
			<div class="hud__legend--color cat6"></div>
			<div class="hud__legend--category">Technical Interview</div>
		</div>
	</div>
	<!--  

	<form method="GET" action="">

		<button type="submit" value=""></button>
	</form>
-->

</div>


		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
		