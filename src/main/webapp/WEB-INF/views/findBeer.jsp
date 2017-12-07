<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Top 10 beers</title>
</head>
<%@    include file="header.jsp"%>


<body class="img"
	style="background-image: url(<c:url value="static/img/newbeers2.jpeg"/>)">


	<div class="container" >
	
		<div class="row">
		<h1 class="text-center" >Beer browser</h1>
		
			<div class="col-xs-8 col-xs-offset-2">

				<div class="input-group">
					<div class="input-group-btn search-panel">
						
							<form method="post">

								<select name="options" class="btn btn-danger">
									
									<option value="-" label="-Search by-">
									<option value="beerName">Beer name</option>
									<option value="brewery">Brewery</option>
									<option value="style">Style</option>
									<option value="alcohol1">Alcohol  >=</option>
									<option value="alcohol2">Alcohol  &lt;=</option>
								
								</select>
							
						</button>
						
					</div>

					<input type="text" class="form-control" name="search"
						placeholder="Find beer..."> <span
						class="input-group-btn">
					<span class="glyphicon glyphicon-search" ><button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" ></span>Search</button>
					</span>
					</form>
				</div>
			</div>
		</div>
	</div>
	<p></p>


	<div class="container" <c:if test="${beers.size() >0}"> style="visibility: none"</c:if>style="visibility: hidden" >
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
							<th scope="col">Add to my beers</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${beers}" var="beer" varStatus="count">
							<tr>
								<td>${count.index+1}</td>
								<td>${beer.username}</td>
								<td>${beer.style}</td>
								<td>${beer.alcohol}%</td>
								<td>${beer.ibu}</td>
								<td>${beer.extract}%</td>
								<td>${beer.brewery}</td>
								<td><a href="<c:url value="/rateBeer/${beer.id}"/>"><button
											class="btn btn-warning">Rate</button></a></td>
								<td><a href="<c:url value="/addMyBeer/${beer.id}"/>"><button
											class="btn btn-success">Add beer</button></a></td>
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