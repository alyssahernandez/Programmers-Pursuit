<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    
		<title>Programmers' Pursuit</title>
		
		<c:url var="stylesheetHref" value="/css/main.css" />
		<c:url var="scriptSrc" value="/js/script.js" />
		<link rel="stylesheet" href="${stylesheetHref}">
		<script src="${ scriptSrc }"></script>
	</head>
	<body>
		<header>
			<h1><a href="<c:url value="/" />">Programmers' Pursuit</a></h1>
			<ul class="navbar-right">
                <c:choose>
                    <c:when test="${empty appCurrentUser}">
<%--                         <c:url var="registerUrl" value="/register"/> --%>
<%--                         <li><a href="${registerUrl}">Register</a></li> --%>
                        <c:url var="loginUrl" value="/login"/>
                        <li id="login"><a href="${loginUrl}">Login</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/"><c:out value="${appCurrentUser.username}" /></a></li>
                        <c:url var="logoffUrl" value="/logout"/>
                        <li>
                            <form action="${logoffUrl}" method="POST" class="navbar-form">
                                <button type="submit" class="btn btn-primary">Log Off</button>
                            </form>
                        </li>
                    </c:otherwise>
				</c:choose>
            </ul>
		</header>
		<main>