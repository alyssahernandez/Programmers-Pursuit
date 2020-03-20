<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
		<title>Trivial Pursuit - TE Edition</title>
		<c:url var="stylesheetHref" value="/sass/main.css" />
		<link rel="stylesheet" href="${stylesheetHref}">
	</head>
	<body>
		<header>
			HEADER
		</header>
		<main>
			<div class="gameboard">
				<div class="gameboard__ring">				
				
					<c:forEach var="i" begin="1" end="6">
						<c:set var="begin" value="${ ((i * 2) - 1) * 6 }"/>
						<c:forEach var="j" begin="${ begin }" end="${ begin + 6 }">
					
							<c:set var="spaceId" value="${ j }"/>
							<c:set var="isNode" value=""/>
							<c:if test="${ (j - 6) % 12 == 0 }">
								<c:set var="isNode" value="space__node"/>
							</c:if>
					
							<div class="space ${ isNode }" id="${ spaceId }"><c:out value="${ spaceId }"/></div>
					
						</c:forEach>
					</c:forEach>
				
				</div>
				<div class="gameboard__spokes">
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>
					<div class="gameboard__spokes--spoke">
						<div class="space space__spoke-space">1</div>
						<div class="space space__spoke-space">2</div>
						<div class="space space__spoke-space">3</div>
						<div class="space space__spoke-space">4</div>
						<div class="space space__spoke-space">5</div>
						<div class="space space__spoke-space">6</div>
					</div>

				</div>
				<div class="gameboard__center space" id="0">0</div>
			</div>
			<div class="hud">
				HUD
			</div>
		</main>
		<footer>
			FOOTER
		</footer>
	</body>
</html>
