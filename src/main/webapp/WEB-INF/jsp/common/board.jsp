<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="gameboard">
	<c:forEach var="player" items="${playersInGame}">
		
		<c:if test="${player.color == 1}">
			<c:set var="player1Pos" value="${player.location.spaceId}" />
		</c:if>
		<c:if test="${player.color == 2}">
			<c:set var="player2Pos" value="${player.location.spaceId}" />
		</c:if>
		<c:if test="${player.color == 3}">
			<c:set var="player3Pos" value="${player.location.spaceId}" />
		</c:if>
		<c:if test="${player.color == 4}">
			<c:set var="player4Pos" value="${player.location.spaceId}" />
		</c:if>
		<c:if test="${player.color == 5}">
			<c:set var="player5Pos" value="${player.location.spaceId}" />
		</c:if>
		<c:if test="${player.color == 6}">
			<c:set var="player6Pos" value="${player.location.spaceId}" />
		</c:if>	
		
	</c:forEach>	
	
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
						<c:set var="category" value="u-color1"/>
					</c:when>
					<c:when test="${ j == 18 || j == 34 || j == 48 || j == 55 || j == 69 }">
						<c:set var="category" value="u-color2"/>
					</c:when>
					<c:when test="${ j == 30 || j == 46 || j == 60 || j == 67 || j == 9 }">
						<c:set var="category" value="u-color3"/>
					</c:when>
					<c:when test="${ j == 42 || j == 58 || j == 72 || j == 7 || j == 21 }">
						<c:set var="category" value="u-color4"/>
					</c:when>
					<c:when test="${ j == 54 || j == 70 || j == 12 || j == 19 || j == 33 }">
						<c:set var="category" value="u-color5"/>
					</c:when>
					<c:when test="${ j == 66 || j == 10 || j == 24 || j == 31 || j == 45 }">
						<c:set var="category" value="u-color6"/> 
					</c:when>
					<c:otherwise>
						<c:set var="category" value="u-colorRollAgain"/>
					</c:otherwise>
				</c:choose>
	
	<!-- 			THIS HIGHLIGHTS A SPACE AS REACHABLE BASED ON THE CURRENT POSITION AND DIE ROLL 
				<c:set var="reachable" value=""/>
				<c:forEach var="id" items="${ reachableSpaces }">
					<c:if test="${ j == id.spaceId }">
						<c:set var="reachable" value="space__reachable"/>
					</c:if>
				</c:forEach>
	-->
	
				
	<!-- THIS IS THE FORM FOR CHOOSING THE CORRECT SPACE - WORK IN PROGRESS - ALYSSA -->
	
				<!-- select on all spaces - when page loads, query for all spaces -
				add event handler - if form isn't null, submit() on click 
				event.target.querySelector('form') - if result is not null/undef ^^-->
				<c:set var="reachable" value=""/>			
				<c:url value="/gameboard/${gameCode}" var="chooseSpaceForm" />
				
					<c:forEach var="id" items="${ reachableSpaces }">
						<c:if test="${ j == id.spaceId }">
							<c:set var="reachable" value="space__reachable"/>						
						</c:if>			
					
					</c:forEach>
				
	<!-- 				THIS ACTUALLY CREATES THE SPACE AS WELL AS ANY PLAYER TOKENS -->
				<div class="space ${ isNode } ${ category } ${ reachable }" id="${ spaceId }">
				
					<c:if test="${player1Pos == j}">
						<div class="player-piece--small u-color1-alt"></div>
					</c:if>
					<c:if test="${player2Pos == j}">
						<div class="player-piece--small u-color2-alt"></div>
					</c:if>
					<c:if test="${player3Pos == j}">
						<div class="player-piece--small u-color3-alt"></div>
					</c:if>
					<c:if test="${player4Pos == j}">
						<div class="player-piece--small u-color4-alt"></div>
					</c:if>
					<c:if test="${player5Pos == j}">
						<div class="player-piece--small u-color5-alt"></div>
					</c:if>
					<c:if test="${player6Pos == j}">
						<div class="player-piece--small u-color6-alt"></div>
					</c:if>
				
					<!-- get by ID form ID - js submit() -->
					<c:if test="${not empty reachable }">
						<form method="POST" action="${chooseSpaceForm}" id="formForSpaceChoice-${j}"
								style="display:none">		
							<input type="hidden" name="spaceChoice" value="${j}"/>
						</form>
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
							<c:set var="category" value="u-color1"/>
						</c:when>
						<c:when test="${ j == 25 || j == 40 || j == 53 || j == 63 || j == 2 }">
							<c:set var="category" value="u-color2"/>
						</c:when>
						<c:when test="${ j == 37 || j == 52 || j == 65 || j == 3 || j == 14 }">
							<c:set var="category" value="u-color3"/>
						</c:when>
						<c:when test="${ j == 49 || j == 64 || j == 5 || j == 15 || j == 26 }">
							<c:set var="category" value="u-color4"/>
						</c:when>
						<c:when test="${ j == 61 || j == 4 || j == 17 || j == 27 || j == 38 }">
							<c:set var="category" value="u-color5"/>
						</c:when>
						<c:when test="${ j == 1 || j == 16 || j == 29 || j == 39 || j == 50 }">
							<c:set var="category" value="u-color6"/>
						</c:when>
					</c:choose>
					
	<!-- 			THIS HIGHLIGHTS A SPACE AS REACHABLE BASED ON THE CURRENT POSITION AND DIE ROLL -->
					<c:set var="reachable" value=""/>
					<c:forEach var="id" items="${ reachableSpaces }">
						<c:if test="${ j == id.spaceId }">
							<c:set var="reachable" value="space__reachable"/>
						</c:if>
					</c:forEach>				
					
	<!-- 				THIS PUTS PIECES IN THE SPACE -->
					<div class="space space__spoke-space ${ category } ${ reachable }">	
					
						<c:if test="${not empty reachable }">
							<form method="POST" action="${chooseSpaceForm}" id="formForSpaceChoice-${j}"
									style="display:none">		
							<input type="hidden" name="spaceChoice" value="${j}"/>
							</form>
						</c:if>
					
						<c:if test="${player1Pos == j}">
							<div class="player-piece--small u-color1-alt"></div>
						</c:if>
						<c:if test="${player2Pos == j}">
							<div class="player-piece--small u-color2-alt"></div>
						</c:if>
						<c:if test="${player3Pos == j}">
							<div class="player-piece--small u-color3-alt"></div>
						</c:if>
						<c:if test="${player4Pos == j}">
							<div class="player-piece--small u-color4-alt"></div>
						</c:if>
						<c:if test="${player5Pos == j}">
							<div class="player-piece--small u-color5-alt"></div>
						</c:if>
						<c:if test="${player6Pos == j}">
							<div class="player-piece--small u-color6-alt"></div>
						</c:if>				
					</div>	
					
				</c:forEach>
			
			</div>						
		</c:forEach>					
	</div>
	
	<!-- 			THIS HIGHLIGHTS THE CENTER SPACE AS REACHABLE BASED ON THE CURRENT POSITION AND DIE ROLL -->
	<c:set var="reachable" value=""/>
	<c:forEach var="id" items="${ reachableSpaces }">
		<c:if test="${ id.spaceId == 0 }">
			<c:set var="reachable" value="space__reachable"/>
		</c:if>
	</c:forEach>	
	
	<!-- THIS IS THE CENTER SPACE -->
	<div class="gameboard__center space ${ reachable }" id="0">
	
		<c:if test="${not empty reachable }">
			<form method="POST" action="${chooseSpaceForm}" id="formForSpaceChoice-0"
					style="display:none">		
				<input type="hidden" name="spaceChoice" value="0"/>
			</form>
		</c:if>
	
		<div>
			<c:if test="${player1Pos == 0}">
				<div class="player-piece--small u-color1-alt"></div>
			</c:if>
			<c:if test="${player2Pos == 0}">
				<div class="player-piece--small u-color2-alt"></div>
			</c:if>
			<c:if test="${player3Pos == 0}">
				<div class="player-piece--small u-color3-alt"></div>
			</c:if>
			<c:if test="${player4Pos == 0}">
				<div class="player-piece--small u-color4-alt"></div>
			</c:if>
			<c:if test="${player5Pos == 0}">
				<div class="player-piece--small u-color5-alt"></div>
			</c:if>
			<c:if test="${player6Pos == 0}">
				<div class="player-piece--small u-color6-alt"></div>
			</c:if>
		</div>
	
	</div>
</div>
