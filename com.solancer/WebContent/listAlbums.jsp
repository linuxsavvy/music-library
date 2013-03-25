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
<title>Show All Albums</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
	        <thead>
	            <tr>
	                <th>Album Id</th>
	                <th>Artist</th>
	                <th>Genre</th>
	                <th>Album Name</th>
	                <th>Album Release</th>
	                <th>Album Info</th>
	                <th>Album Image</th>
	                <th class="text-centered" colspan="2">Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${albums}" var="album">
	                <tr>
	                    <td><c:out value="${album.albumId}" /></td>
	                    <td><c:out value="${album.alArtistId}" /></tdz>
	                    <td><c:out value="${album.alGenreId}" /></td>
	                    <td><c:out value="${album.albumName}" /></td>
	                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${album.albumRelease}" /></td>
	                    <td><c:out value="${album.albumInfo}" /></td>
	                    <td><c:out value="${album.albumImage}" /></td>
	                    <td><a href="AlbumController?action=edit&AlbumId=<c:out value="${album.albumId}"/>">Update</a></td>
	                    <td><a href="AlbumController?action=delete&AlbumId=<c:out value="${album.albumId}"/>">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p><a href="AlbumController?action=insert">Add Album</a></p>
    </div>
</body>
</html>