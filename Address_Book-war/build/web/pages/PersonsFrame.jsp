<%@ page pageEncoding="windows-1251" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html>
    <head>
        <title>Адресная книга</title>
    </head>
  
    <body>
        <form action='<c:url value="/person.prj"/>' method="POST">
	        <b>Адресная книга</b><br/>
	        <table>
	            <tr>
		        <th>&nbsp;</th>
		        <th>Фамилия</th>
		        <th>Имя</th>
		        <th>Отчество</th>
		    </tr>
		    <c:forEach var="person" items="${personsList}">
		        <tr>
                            <td><input type="radio" name="personId" value="${person.personId}"/></td>
			    <td><c:out value="${person.lastName}"/></td>
			    <td><c:out value="${person.firstName}"/></td>
			    <td><c:out value="${person.middleName}"/></td>
			</tr>
		    </c:forEach>
		</table>
		    <table>
			<tr>
		            <td><input type="submit" name="Contacts" value="Contacts"/></td>
			</tr>
			<tr>
			    <td><input type="submit" name="Add" value="Add"/></td>
			    <td><input type="submit" name="Edit" value="Edit"/></td>
			    <td><input type="submit" name="Delete" value="Delete"/></td>
			</tr>
		    </table>
        </form>
    </body>
</html>
					 
	  