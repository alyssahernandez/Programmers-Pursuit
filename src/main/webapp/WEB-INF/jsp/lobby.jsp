<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="joinGameURL" value="/joinGame"/>
<c:url var="createGame" value="common/createGame.jsp"/>

<h2 class="headers__lobby u-margin-bottom-medium">Game Lobby</h2>
<div class="lobby">	
  <div class="games">
    <h3>Public Games</h3>
    <c:forEach var="game" items="${openGames}">
    <div>
      <div>
        Game Code: <c:out value="${game.gameCode }"/><br>
        Capacity: <c:out value="${game.activePlayers.size()}/6"/><br>
        Categories: ${game.uniqueCategories.get(0).categoryName}<c:forEach var="index" begin="1" end="${game.uniqueCategories.size() - 1}">,
        <fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
        ${game.uniqueCategories.get(intValue).categoryName}
        </c:forEach>
      </div>
      <div>
        <form method="POST" action="${joinGameURL}">
          <input type="submit" class="button--small" value="Join"/>
          <input type="hidden" value="${game.gameCode }" name="gameCode"/>
        </form>	
      </div>
    </div>
    </c:forEach>
  </div>
  <div class="games">
  	<h2>Your Games</h2>
  	<div class="games__active">
  		<h4>Active Games</h4>
  		<div>
		    <c:forEach var="game" items="${activeGamesByUser}">
		    <div>
		      <div>
				Players: ${game.activePlayers.get(0).name }<c:forEach var="index" begin="1" end="${game.activePlayers.size() - 1 }">, ${game.activePlayers.get(index).name}</c:forEach><br>
		        Categories: ${game.uniqueCategories.get(0).categoryName}<c:forEach var="index" begin="1" end="${game.uniqueCategories.size() - 1}">,
		        <fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
		        ${game.uniqueCategories.get(intValue).categoryName}
		        </c:forEach>
		      </div>
		      <div>
		        <form method="POST" action="${joinGameURL}">
		          <input type="submit" class="button--small" value="Join"/>
		          <input type="hidden" value="${game.gameCode }" name="gameCode"/>
		        </form>	
		      </div>
		    </div>
		    </c:forEach>
  		</div>
  	</div>
  	<div class="games__pending">
  		<h4>Pending Games</h4>
  		<div>
		    <c:forEach var="game" items="${unstartedGamesByUser}">
		    <div>
		      <div>
		        Players: <c:forEach var="player" items="${game.activePlayers }">${player.name } </c:forEach><br>
		        Categories: ${game.uniqueCategories.get(0).categoryName}<c:forEach var="index" begin="1" end="${game.uniqueCategories.size() - 1}">,
		        <fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
		        ${game.uniqueCategories.get(intValue).categoryName}
		        </c:forEach>
		      </div>
		      <div>
		        <form method="POST" action="${joinGameURL}">
		          <input type="submit" class="button--small" value="Join"/>
		          <input type="hidden" value="${game.gameCode }" name="gameCode"/>
		        </form>	
		      </div>
		    </div>
		    </c:forEach>
  		</div>
  	</div>
  	  	<div class="games__completed">
  		<h4>Completed Games</h4>
  		<div>
		    <c:forEach var="game" items="${completedGamesByUser}">
		    <div>
		      <div>
		        Players: <c:forEach var="player" items="${game.activePlayers }">${player.name } </c:forEach><br>
		        Categories: ${game.uniqueCategories.get(0).categoryName}<c:forEach var="index" begin="1" end="${game.uniqueCategories.size() - 1}">,
		        <fmt:parseNumber var="intValue" value="${index}" integerOnly="true"/>
		        ${game.uniqueCategories.get(intValue).categoryName}
		        </c:forEach>
		      </div>
		      <div>
		        <form method="POST" action="${joinGameURL}">
		          <input type="submit" class="button--small" value="Join"/>
		          <input type="hidden" value="${game.gameCode }" name="gameCode"/>
		        </form>	
		      </div>
		    </div>
		    </c:forEach>
  		</div>
  	</div>
  </div>
  
  <c:import url="${ createGame }" />

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />