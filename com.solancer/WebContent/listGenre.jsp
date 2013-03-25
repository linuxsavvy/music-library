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
<title>Show All Genres</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
	        <thead>
	            <tr>
	                <th>Genre Id</th>
	                <th>Genre Name</th>
	                <th colspan="2" class="text-centered">Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${genres}" var="genre">
	                <tr>
	                    <td><c:out value="${genre.genreid}" /></td>
	                    <td><c:out value="${genre.genreName}" /></td>
	                    <td><a href="GenreController?action=edit&genreId=<c:out value="${genre.genreid}"/>">Update</a></td>
	                    <td><a href="GenreController?action=delete&genreId=<c:out value="${genre.genreid}"/>">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p><a href="GenreController?action=insert">Add Genre</a></p>
</div>
    
</body>
</html>