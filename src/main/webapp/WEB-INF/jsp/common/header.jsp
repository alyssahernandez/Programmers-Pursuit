<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    
		<title>Trivial Pursuit - TE Edition</title>
		
		<c:url var="stylesheetHref" value="/css/main.css" />
		<c:url var="scriptSrc" value="/js/script.js" />
		<link rel="stylesheet" href="${stylesheetHref}">
		<script src="${ scriptSrc }"></script>
	</head>
	<body>
		<header>
			<h1><a href="<c:url value="/" />">Trivial Pursuit - TE Edition</a></h1>
			<div></div>
				<ul class="nav navbar-nav navbar-right">
	                <c:choose>
	                    <c:when test="${empty appCurrentUser}">
	                        <c:url var="loginUrl" value="/login"/>
	                        <li><a href="${loginUrl}">Login</a></li>
	                        <c:url var="registerUrl" value="/register"/>
	                        <li><a href="${registerUrl}">Register</a></li>
	                    </c:when>
	                    <c:otherwise>
	                        <li><a href="/"><c:out value="${appCurrentUser.username}" /></a></li>
	                        <c:url var="logoffUrl" value="/logoff"/>
	                        <li>
	                            <form action="${logoffUrl}" method="POST" class="navbar-form">
	                                <button type="submit" class="btn btn-primary">Log Off</button>
	                            </form>
	                        </li>
	                    </c:otherwise>
					</c:choose>
	            </ul>
            </div>
		</header>
		<main>