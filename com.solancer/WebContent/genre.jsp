<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/head.jsp">
  <jsp:param name="title" value="Choose a Production" />
</jsp:include>
<title>Add New Genre</title>
</head>
<body>
	<div class="container">
		<form method="post" action="GenreController" name="frmAddGenre"  class="form-stuff">
			<fieldset>
				<legend>Genre</legend>
				<label>Genre ID</label>
				<input type="text" readonly="readonly" name="genreId" value="<c:out value="${genre.genreid}" />" /> <br />
				<label>Genre Name</label> 
				<input type="text" name="genreName" value="<c:out value="${genre.genreName}" />" /> <br />
		        <input type="submit" value="Submit" class="btn" />
		    </fieldset>
		</form>
	</div>
</body>
</html>