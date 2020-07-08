<html>
	<head>
		<title>Employee Hub</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="wrapper">
			<a class="back" href="<%=request.getContextPath()%>">Home</a><br /><br />
			<h1>Import File</h1>
			<form action="/importer/importFile" enctype="multipart/form-data" method="POST">
				<h2>Upload Employee List</h2>
				<input type="file" name="file" size="40"><br>
				<input type="submit" value="Upload">
			</form>
		</div>
	</body>
</html>
