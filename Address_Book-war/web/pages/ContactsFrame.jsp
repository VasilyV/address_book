<%@ page pageEncoding="windows-1251" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html>
    <head>
	<title>Контакты</title>
    </head>
	
    <body>
	<form action='<c:url value="/contact.prj"/>' method="POST">
            <table>
                <c:forEach var="p" items="${personsList}">
                    <input type="hidden" name="personId" value="${p.personId}"
		    <tr>
			<th><c:out value="${p.lastName}"/></th>
			<th><c:out value="${p.firstName}"/></th>
			<th><c:out value="${p.middleName}"/></th>
		    </tr>
		</c:forEach>
		<c:forEach var="p" items="${personsList}">
		    <c:forEach var="contact" items="${p.contacts}">
			<tr>
			    <td><input type="radio" name="contactId" value="${contact.contactId}"/></td>
			    <td><c:out value="${contact.phoneNumber}"/></td>
			    <td><c:out value="${contact.email}"/></td>
			</tr>
		    </c:forEach>
		</c:forEach>
	    </table>
	    <table>
	        <tr>
		    <td><input type="submit" name="Add" value="Add"/></td>
		    <td><input type="submit" name="Edit" value="Edit"/></td>
		    <td><input type="submit" name="Delete" value="Delete"/></td>
                    <td><input type="submit" name="Back" value="Back"/></td>
		</tr>
	    </table>
	</form>
    </body>
</html>
			    
			