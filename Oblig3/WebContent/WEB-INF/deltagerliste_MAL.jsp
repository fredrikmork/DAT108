<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<tr bgcolor="#aaffaa">
			<td align="center">&#9792;</td>
			<td>Anne Annesen</td>
			<td>445 54 455</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center">&#9794;</td>
			<td>Arne Arnesen</td>
			<td>901 23 456</td>
		</tr>
		<c:forEach items="${liste}" var="p">
		<tr bgcolor="#ffffff">
			<td align="center"> 
					<c:choose><c:when test="${p.kjonn ='kvinne'}">&#9792;</c:when><c:otherwise>&#9794;</c:otherwise></c:choose></td>
			<td>${p.fornavn} + " " +  ${p.etternavn}</td>
			<td>${p.mobil}</td>
		</tr>
		</c:forEach>
	</table>
	<p>
		<a href="FerdigServlet">Ferdig</a>
	</p>
</body>
</html>