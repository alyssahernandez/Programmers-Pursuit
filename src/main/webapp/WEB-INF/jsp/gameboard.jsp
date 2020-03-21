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
		
				<div class="space ${ isNode }" id="${ spaceId }"><c:out value="${ spaceId }"/></div>
		
			</c:forEach>
		</c:forEach>
	</div>

<!-- THIS SECTION GENERATES THE INNER RING OF "SPOKES" -->
	<div class="gameboard__spokes">					
		<c:forEach var="i" begin="1" end="6">						
			<div class="gameboard__spokes--spoke">
				
				<c:set var="firstSpaceId" value="${ ((i - 1) * 12) + 1 }"/>
				
				<c:forEach var="j" begin="${ firstSpaceId }" end="${ firstSpaceId + 4 }">
					<div class="space space__spoke-space"><c:out value="${ j }"/></div>	
				</c:forEach>
			
			</div>						
		</c:forEach>					
	</div>
	
<!-- THIS IS THE CENTER SPACE -->
	<div class="gameboard__center space" id="0">0</div>

</div>
<div class="hud">
<!-- THIS IS WHERE THE HUD WILL GO -->
</div>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
		