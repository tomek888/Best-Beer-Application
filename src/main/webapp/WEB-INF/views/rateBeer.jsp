<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		

		<title>Admin</title>
</head>
<%@    include file="header.jsp"%>
<body>
<body style="background-image: url(<c:url value="static/img/newbeers2.jpeg"/>)">

<div class="container">
<div class="col-md-3">
</div>
<div class="col-md-6">
    <div class="form-area">  
        <form:form   method="post" modelAttribute="rating">
        <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">Rate beer</h3>
    				<div class="form-group">
						Aroma <form:input type="numeric" path="aroma" />
					</div>
					<div class="form-group">
						Apperance <form:input type="numeric" path="apperance" />
					</div>
					<div class="form-group">
						Taste <form:input type="numeric" path="taste" />
					</div>
					<div class="form-group">
						Palate <form:input type="numeric" path="palate" />
					</div>
					<div class="form-group">
						Overall <form:input type="numeric" path="overall" />
					</div>
                    <div class="form-group">
                    <form:textarea class="form-control" path="description" type="textarea" id="message" placeholder="Message" maxlength="140" rows="7"/>
                                           
                    </div>
            
        <button type="submit"  class="btn btn-primary pull-right">Submit</button>
        </form:form>
    </div>
</div>
<div class="col-md-3">
</div>
</div>

</body>
</html>