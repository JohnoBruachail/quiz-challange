<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 

    <table border="1">
    	<tr>
			<th>User</th>
			<th>Score</th>
		</tr>
		
		<c:forEach var="results" items="${listResults}" varStatus="status">
			<tr>
			    <td>${results.getUserName()}</td>
			    <td>${results.getScore()}</td>       
			</tr>
		</c:forEach>             
	</table>
</body>
</html>