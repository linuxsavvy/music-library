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
<title>Add New Artist</title>
</head>
<body>
	<div class="container">
		<form method="post" action="ArtistController" name="frmAddArtist"  class="form-stuff">
			 <fieldset>
				<legend>Artist</legend>
				<label>Artist ID</label>
				<input type="text" readonly="readonly" name="artistId" value="<c:out value="${artist.artistid}" />" />
				<label>Artist Name</label> 
				<input type="text" name="artistName" value="<c:out value="${artist.artistName}" />" />
		        <input type="submit" value="Submit" class="btn" />
			  </fieldset>
		</form>
	</div>
</body>
</html>