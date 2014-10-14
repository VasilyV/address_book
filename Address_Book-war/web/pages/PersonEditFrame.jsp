<%@ page pageEncoding="windows-1251" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html>
    <head>
	 <title>Редактирование персональных данных</title>
    </head>
	
	<body>
	    <form action='<c:url value="/editaddperson.prj"/>' method="POST">
                <c:forEach var="person" items="${personsList}">
                    <input type="hidden" name="personId" value="${person.personId}"/>
		        <table>
		            <tr>
			        <td>Фамилия</td>
			        <td><input type="text" name="lastName" value="${person.lastName}"/></td>	
			    </tr>
			    <tr>
			        <td>Имя</td>
		                <td><input type="text" name="firstName" value="${person.firstName}"/></td>
			    </tr>
			    <tr>
			        <td>Отчество</td>
			        <td><input type="text" name="middleName" value="${person.middleName}"/></td>
			    </tr>
		        </table>
                </c:forEach>
		    <table>
		        <tr>
			    <td><input type="submit" name="Ok" value="Ok"/></td>
			    <td><input type="submit" name="Cancel" value="Cancel"/></td>
		        </tr>
		    </table>
	    </form>
	</body>
</html>
	
