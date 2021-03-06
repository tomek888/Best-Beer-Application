<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Best beer</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>

		
</head>

<body>

 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Best beer</a>
    </div>
    <ul class="nav navbar-nav">
      <li<%--  class="active"--%>><a href="<c:url value="/mainPage"/>"><span class="glyphicon glyphicon-home"></span>&nbsp;Home</a></li>
      <li><a href="<c:url value="/top10beers"/>"><span class="glyphicon glyphicon-star"></span>&nbsp;Top 10 beers</a></li>
      <li><a href="<c:url value="/addBeer"/>"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add new beer</a></li>
      <li><a href="<c:url value="/findBeer"/>"><span class="glyphicon glyphicon-search"></span>&nbsp; Find beer</a></li>
      <li><a href="<c:url value="/myBeers"/>"> <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp; My beers</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;${username}</a></li>
      <li><a href="<c:url value="/logOut"/>"><span class="glyphicon glyphicon-log-in"></span>&nbsp; Sing out</a></li>
    </ul>
  </div>
</nav> 

		

</body>
</html>