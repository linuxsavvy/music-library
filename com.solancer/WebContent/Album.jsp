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
<title>Add New Album</title>
</head>
<body>
<script>
    $(function() {
        $('#datepicker').datepicker();
    });
</script>

	<div class="container">
		<form method="post" action="AlbumController" name="frmAddAl" class="form-stuff">
			 <fieldset>
				<legend>Album</legend>
				
				<label>Album ID</label>
				<input type="text" readonly="readonly" name="AlbumId" value="<c:out value="${album.albumId}" />" />
				<label>Artist</label>
				<input type="text" name="AlArtistid" value="<c:out value="${album.alArtistId}" />" />
				<%-- <select>
					<c:forEach items="artists" var="artist">
						<option value="<c:out value="${artist}"/>"><c:out value="${artist}"/></option>
						<% System.out.println(pageContext.findAttribute("artist") ); %>
					</c:forEach>
				</select> --%>
				<label>Genre</label>
				<input type="text" name="AlGenreid" value="<c:out value="${album.alGenreId}" />" />
				<label>Album Name</label> 
				<input type="text" name="AlbumName" value="<c:out value="${album.albumName}" />" />
				<label>Release Date</label>
				<input type="text" name="AlbumRelease" id="datepicker" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${album.albumRelease}" />" />
				<% System.out.println(pageContext.findAttribute("album.albumRelease") ); %>
				<label>Album Image</label>
				<input type="text" name="AlbumImage" value="<c:out value="${album.albumImage}" />" />
				<textarea name="AlbumInfo" class="form-textarea"><c:out value="${album.albumInfo}"/></textarea>
		        <input type="submit" value="Submit" class="btn" />
			  </fieldset>
		</form>
	</div>
</body>
</html>