<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Create Location</title>
</head>
<body>
	<form action="saveloc" method="post">
		<pre>
			Id: <input type="text" name="id"/>
			Code: <input type="text" name="code"/>
			Name: <input type="text" name="name"/>
			Type: Urban <input type="radio" name="type" value="URBAN"/>
			Rural <input type="radio" name="type" value="RURAL"/>
			<input type="submit" name="save"/>
		</pre>
	</form>
${msg}
<a href="displayLocations">View All</a>
</body>
</html>