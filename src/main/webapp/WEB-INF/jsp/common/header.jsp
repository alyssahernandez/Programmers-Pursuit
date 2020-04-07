<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    
		<title>Trivial Pursuit - TE Edition</title>
		
		<c:url var="stylesheetHref" value="/css/main.css" />
		<link rel="stylesheet" href="${stylesheetHref}">
	</head>
	<body>
		<header>
			<h1><a href="<c:url value="/" />">Trivial Pursuit - TE Edition</a></h1>
		</header>
		<main>