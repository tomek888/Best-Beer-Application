<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
<title>Top 10 beers </title>
</head>
<%@    include file="header.jsp"%>
<body>
<%-- 

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Best beer</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="<c:url value="/top10beers"/>">Top 10 beers</a></li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>${user.username}</a></li>
      <li><a href="<c:url value="/userReg"/>"><span class="glyphicon glyphicon-log-in"></span> Sing out</a></li>
    </ul>
  </div>
</nav> 
--%>
<body class="img" style="background-image: url(<c:url value="static/img/newbeers2.jpeg"/>)">


<div class="container">
	<div class="row">
		<div class="table-responsive">
            <table id="main-table" class="table exotic-table">
                <thead>
                    <tr class="text-center">
                        <th scope="col">Rank</th>
					      <th scope="col">Name</th>
					      <th scope="col">Style</th>
					      <th scope="col">Alcohol</th>
					      <th scope="col">IBU</th>
					      <th scope="col">Extract</th>
					      <th scope="col">Brewery</th>
					      <th scope="col">Rate</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                <c:forEach items="${beers}" var="beer">
                    <tr>
                         <td>-</td>
				      <td>${beer.username}</td>
				      <td>${beer.style}</td>
				      <td>${beer.alcohol} %</td>
				      <td>${beer.ibu}</td>
				      <td>${beer.extract} %</td>
				      <td>${beer.brewery}</td>
				      <td><a href="<c:url value="/rateBeer"/>"><button class="btn btn-warning">  Rate </button></a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
	</div>
</div>

<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover({title: "Payment Modes",html: true, placement: "left"});   
});
</script>



</body>
</html>