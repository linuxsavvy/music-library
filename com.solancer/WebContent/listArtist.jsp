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
<title>Show All Artists</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
	        <thead>
	            <tr>
	                <th>Artist Id</th>
	                <th>Artist Name</th>
	                <th class="text-centered" colspan="2">Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${artists}" var="artist">
	                <tr>
	                    <td><c:out value="${artist.artistid}" /></td>
	                    <td><c:out value="${artist.artistName}" /></td>
	                    <td><a href="ArtistController?action=edit&artistId=<c:out value="${artist.artistid}"/>">Update</a></td>
	                    <td><a href="ArtistController?action=delete&artistId=<c:out value="${artist.artistid}"/>">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p><a href="ArtistController?action=insert">Add Artist</a></p>
    </div>
	
</body>
</html>