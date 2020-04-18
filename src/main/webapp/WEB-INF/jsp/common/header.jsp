<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    
		<title>Programmers' Pursuit</title>
		
		<c:url var="stylesheetHref" value="/css/main.css" />
		<link rel="stylesheet" href="${stylesheetHref}">
		
		<c:url var="jsURL" value="/js/script.js" />
		<script src="${ jsURL }"></script>
	</head>
	<body>
<<<<<<< HEAD
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
=======
		<header class="header">

            <c:url var="homepageURL" value="/"/>
            <h1 class="header-main"><a href="${ homepageURL }">Programmers' Pursuit</a></h1>
            
			<ul class="header__right-nav">
                <c:url var="profileURL" value="/profile"/>
                <li class="header__right-nav--link link header-link" id="profile"><a href="${profileURL}">Profile</a></li>
>>>>>>> 6b51d0bd70dd0c0bc7dd2de09fd3a8b739023dea
            </ul>
            
		</header>
		<main class="main-content">