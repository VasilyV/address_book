<%@ page pageEncoding="windows-1251" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html>
    <head>
	<title>Фамилия Имя Отчество</title>
    </head>
        <body>
	    <form action='<c:url value="/editcontact.prj"/>' method="POST">
                <c:forEach var="contact" items="${contactsList}">
                    <input type="hidden" name="personId" value="${contact.personId}"/>
                    <input type="hidden" name="contactId" value="${contact.contactId}"/>
                        <table>
                            <tr>
			        <td>Телефон</td>
			        <td><input type="text" name="phoneNumber" value="${contact.phoneNumber}"/></td>	
	                    </tr>
	                    <tr>
			        <td>Email</td>
			        <td><input type="text" name="email" value="${contact.email}"/></td>
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
	