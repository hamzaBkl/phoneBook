<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  

<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts page</title>
</head>
<body>
<h1>Contacts list"</h1>
    <s:form action="getAll">
        <table>
            <thead>
            <td>ID Contact</td>
            <td>Pseudo</td>
            <td>Mail</td>
            <td>Code Postal</td>
            <td>Date Inscription</td>
            <td>Photo</td>
            </thead>

            <s:if test="%{contacts.size()>0}">
                <tr>
                    <s:iterator value="contacts" status="contact">
                        <td><s:property value="contact.id"></s:property> </td>
                        <td><s:property value="contact.pseudo"></s:property> </td>
                        <td><s:property value="contact.mail"></s:property> </td>
                        <td><s:property value="contact.codePostal"></s:property> </td>
                        <td><s:property value="contact.dateinscription"></s:property> </td>
                        <td><s:property value="contact.photo"></s:property> </td>
                    </s:iterator>
                </tr>
            </s:if>
        </table>
    </s:form>

</body>
</html>