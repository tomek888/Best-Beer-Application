<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	

		<title>Admin</title>
</head>
<%@    include file="header.jsp"%>
<body style="background-image: url(<c:url value="/static/img/newbeers2.jpeg"/>)">
<div class="container">
    
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  
			  	<div class="panel-body">
			    	<form:form  method="post" modelAttribute="beer" role="form">
                    <fieldset>
			    	  	<div class="form-group">
						<label for="username" class="col-md-6 control-label">Beer name</label>
			    		    <form:input class="form-control" path="username" placeholder="Beer name"  type="text"/>
			    		</div>
			    		<label for="style" class="col-md-6 control-label">Style</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="style" placeholder="Style"  type="text"/>
			    		</div>
			    		<label for="extract" class="col-md-6 control-label">Extraact</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="extract" placeholder="Extract"  type="text"/>
			    		</div>
			    		<label for="alcohol" class="col-md-6 control-label">Alcohol</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="alcohol" placeholder="Alcohol"  type="text"/>
			    		</div>
			    		<label for="ibu" class="col-md-6 control-label">IBU</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="ibu" placeholder="IBU"  type="text"/>
			    		</div>
			    		<label for="brewery" class="col-md-6 control-label">Brewery</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="brewery" placeholder="Brewery"  type="text"/>
			    		</div>
			    		<label for="bestTemp" class="col-md-6 control-label">Best temp.</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="bestTemp" placeholder="Best temp."  type="text"/>
			    		</div>
			    			<label for="glass" class="col-md-6 control-label">Glass</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="glass" placeholder="Glass"  type="text"/>
			    		</div>
			    		<label for="culinary" class="col-md-6 control-label">Culinary</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="culinary" placeholder="Culinary"  type="text"/>
			    		</div>
			    		
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Add new beer">
			    	</fieldset>
			      	</form:form>
			    </div>
			</div>
		</div>
	</div>
</div>

</body>
</html>