<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Contact</title>
</head>
<body>
    <s:form action="add">
    <s:textfield name="pseudo" label="Pseudo"></s:textfield>  
    <s:textfield name="mail" label="Mail"></s:textfield>  
    <s:textfield name="codePostal" label="Code Postal"></s:textfield>  
    <s:textfield name="photo" label="Photo"></s:textfield>  
    <s:submit value="save"></s:submit>  
    </s:form>  

</body>
</html>