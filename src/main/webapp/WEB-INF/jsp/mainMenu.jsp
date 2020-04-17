<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		<main class="homepage">
			<div class="homepage__titles u-center-text u-margin-bottom-big">
				<h1 class="title">Programmers' Pursuit</h1>
				<h2 class="subtitle">Brought to you by Philly Cohort<span class="homepage--bracket">[</span><span class="homepage--zero">0</span><span class="homepage--bracket">]</span></h2>
			</div>

			<c:url var="loginUrl" value="/login"/>
			<a href="${loginUrl}" class="button">Login</a>
			
			<div class="homepage__links">
				<a href="#" class="homepage--link">About the Team</a>
			</div>
		</main>
	</body>
</html>
