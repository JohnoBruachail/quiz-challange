<%@page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 
 
    <h1>Welcome to the quiz</h1>
    
    <form:form action="submitAnswers" method="post" commandName="results">

		<p>The following is a list of currently running auction's</p>
		<table  border="1">
			<tr>
				<th>Question</th>
				<th>Answer 1</th>
				<th>Answer 2</th>
				<th>Answer 3</th>
			</tr>
			<c:forEach var="question" items="${listQuestion}" varStatus="status">
			<tr>
				<td>${question.question}</td>
				<td><form:radiobutton path="Q${question.getID()}" value="1"/>${question.answerOne}<br></td>
				<td><form:radiobutton path="Q${question.getID()}" value="2"/>${question.answerTwo}</td>
				<td><form:radiobutton path="Q${question.getID()}" value="3"/>${question.answerThree}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="submit" value="Complete"></td>
			</tr>
		</table>
	
	</form:form>
	
</body>
</html>