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
		<div class="homepage">
			<h1 class="homepage__title">Programmers' Pursuit</h1>
			<h2 class="homepage__subtitle">Brought to you by Philly Cohort<span class="homepage__bracket">[</span><span class="homepage__zero">0</span><span class="homepage__bracket">]</span></h2>
			
<!-- 			<p class="homepage__content">Lorem ipsum dolor sit amet, consul tractatos ut nam, duis  -->
<!-- 				dicant ad vim. Mea eruditi temporibus id. Quo eu nostro accusamus theophrastus. Mel  -->
<!-- 				exerci postea mandamus in, mei meliore phaedrum consequuntur ei, quo at nulla laboramus.  -->
<!-- 				Veri quando dolorum vim ad. -->
<!-- 			</p> -->
		
<!-- 			<p class="homepage__content">Cum no velit expetenda voluptatum, omnium suscipit repudiandae et vim, ne mel enim  -->
<!-- 				quaeque indoctum. Eam mundi elitr et, quas brute at vel. Vide rationibus no vis, ad  -->
<!-- 				veniam bonorum facilisi sit, periculis iracundia definitiones qui cu. Doming vulputate  -->
<!-- 				vim ut, exerci altera ad nec, mei petentium adversarium ea. -->
<!-- 			</p> -->
			
			<c:url var="loginUrl" value="/login"/>
            <a href="${loginUrl}" class="homepage__login">Login</a>
			<a href="#" class="homepage__about-us">About the Team</a>
		</div>
	</body>
</html>
