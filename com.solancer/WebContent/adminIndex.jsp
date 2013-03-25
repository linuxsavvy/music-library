<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/head.jsp">
  <jsp:param name="title" value="Choose a Production" />
</jsp:include>
<title>Admin Home</title>
</head>
<body>
	<div class="container">
		<ul>
			<li><a href="ArtistController?action=listartist">Artist</a>
			<li><a href="GenreController?action=listgenre">Genre</a>
			<li><a href="AlbumController?action=listalbum">Album</a>
		</ul>
	</div>
</body>
</html>