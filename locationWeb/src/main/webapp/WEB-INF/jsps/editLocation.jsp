<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Create Location</title>
</head>
<body>
	<form action="updateLoc" method="post">
		<pre>
			Id: <input type="text" name="id" value="${location.id}" readonly/>
			Code: <input type="text" name="code" value="${location.code}"/>
			Name: <input type="text" name="name" value="${location.name}"/>
			Type: Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''}/>
				Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/>
			<input type="submit" name="save"/>
		</pre>
	</form>
</body>
</html>