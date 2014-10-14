<%@ page pageEncoding="windows-1251" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html>
    <head>
	<title>Фамилия Имя Отчество</title>
    </head>
        <body>
	    <form action='<c:url value="/addcontact.prj"/>' method="POST">
                <c:forEach var="p" items="${personsList}">
                    <input type="hidden" name="personId" value="${p.personId}"/>
                    <table>
	                <tr>
		            <th>&nbsp;</th>
		            <th><c:out value="${p.lastName}"/></th>
			    <th><c:out value="${p.firstName}"/></th>
		            <th><c:out value="${p.middleName}"/></th>
		        </tr>
		    </table>
                </c:forEach>
		<table>
		    <tr>
			<td>Телефон</td>
			<td><input type="text" name="phoneNumber" value=""/></td>	
	            </tr>
	            <tr>
			<td>Email</td>
			<td><input type="text" name="email" value=""/></td>
		    </tr>
		</table>
                   
		<table>
		    <tr>
			<td><input type="submit" name="Ok" value="Ok"/></td>
			<td><input type="submit" name="Cancel" value="Cancel"/></td>
	            </tr>
		</table>
	    </form>
	</body>
</html>
	