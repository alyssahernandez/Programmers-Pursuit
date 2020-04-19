<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var = "headerURL" value="common/header.jsp" />
<c:url var = "boardURL" value="common/board.jsp" />
<c:url var = "hudURL" value="common/hud.jsp" />
<c:url var = "footerURL" value="common/footer.jsp" />

<c:import url="${ headerURL }" />

<c:import url="${ boardURL }" />

<c:import url="${ hudURL }" />
		
<c:import url="${ footerURL }" />
		