<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Strategies</title>
</head>
<body>
<h1>Lista de Estrategias</h1>
<p>Lista de Estratégias para editar.</p>
<table class="table table-striped" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">id</th><th width="15%">name</th><th width="10%">type</th><th width="10%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="estrategia" items="${listaEstrategia}">
<tr>
	<td>${estrategia.id}</td>
	<td>${estrategia.name}</td>
	<td>${estrategia.type}</td>
	<td>
	<a href="${pageContext.request.contextPath}/estrategia/editar/${estrategia.id}">Editar</a><br/>
	<a href="${pageContext.request.contextPath}/estrategia/deletar/${estrategia.id}">Deletar</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>

</body>
</html>