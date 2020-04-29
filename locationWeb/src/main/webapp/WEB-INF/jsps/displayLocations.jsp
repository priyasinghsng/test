<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Create Location</title>
</head>
	<body>
	
	<h1>Locations: </h1>
		<table>
			<tr>
				<th>id</th>
				<th>code</th>
				<th>name</th>
				<th>type</th>
			</tr>
			<c:forEach items="${locations}" var="location">
			<tr>
				<td>${location.id}</td>
				<td>${location.code}</td>
				<td>${location.name}</td>
				<td>${location.type}</td>
				<td><a href="deleteLocation?id=${location.id}">delete</a></td>
				<td><a href="showUpdate?id=${location.id}">edit</a></td>
			</tr>
			</c:forEach>
		</table>
		<a href="showCreate">Add Record</a>
	</body>
</html>