<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
	

		

		<title>Rate beer</title>
</head>
<%@    include file="header.jsp"%>
<body class="img" style="background-image: url(<c:url value="/static/img/test.jpeg"/>)">

<div class="container">
<div class="col-md-3">

</div>
<div class="col-md-6">
    <div class="form-area"> 
     
        <form:form   method="post" modelAttribute="rating">
        <br style="clear:both">
         <div class="panel-title text-center">
	               		<h2 class="title">Rate beer</h2>
	               		<hr />
	               	</div>
                    
                    <input type="hidden" name="id" value=${beerId}  />
                    
    				<div class="form-group">
						<div class="col-md-3">Aroma</div><div class="col-md-1"></div><div class="col-md-2">
						<form:input class="btn btn-warning" type="number" min="1" max="10" step="1" path="aroma" /></div><br>
					</div>
					<div class="form-group">
						<div class="col-md-3">Apperance</div><div class="col-md-1"></div><div class="col-md-2">
						<form:input class="btn btn-success" type="number" min="1" max="10" step="1" path="apperance" /></div><br>
					</div>
					<div class="form-group">
						<div class="col-md-3">Taste</div><div class="col-md-1"></div><div class="col-md-2">
						<form:input class="btn btn-info" type="number" min="1" max="10" step="1" path="taste" /></div><br>
					</div>
					<div class="form-group">
						<div class="col-md-3">Palate</div><div class="col-md-1"></div><div class="col-md-2">
						<form:input class="btn btn-danger" type="number" min="1" max="10" step="1" path="palate" /></div><br>
					</div>
					<div class="form-group">
						<div class="col-md-3">Overall</div><div class="col-md-1"></div><div class="col-md-2">
						<form:input class="btn btn-primary" type="number" min="1" max="10" step="1" path="overall" /></div><br>
					</div>
		
                    <form:textarea class="form-control" path="description" type="textarea" id="message" placeholder="Opinion" maxlength="140" rows="7"/>
                         <button type="submit"  class="btn btn-primary pull-right">Submit</button>                  
                    </div>
            
        
        </form:form>
    </div>
</div>
<div class="col-md-3">
</div>
</div>

</body>
</html>