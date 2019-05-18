<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<spring:url value="/res/styles/" var="css" />
	<spring:url value="/res/scripts/" var="js" />
	<spring:url value="/res/images/" var="img" />
	<!-- Spring Csss and Images -->
	<link rel="stylesheet" type="text/css" href="${css}bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${css}style1.css">
	<!-- END Spring Csss and Images -->

</head>
<body>
	<style>
		body
			{		
				background-repeat: no-repeat;
				background-size: 100%;
			}
	</style>

		<!--Input Fields begins here-->
		<div class="col col-md-offset-2 col-md-7" style="margin-left:500px; ">
			<div class="row">
				<h1 id="containers" style="margin-left: 190px;"><u>Edit Form</u></h1>
		</div>
		<form action="C:/Users/ACER/Desktop/sms/adminHome.html" method="post">
			
			<div class="row">
					<div class="col-md-4">
					<div class="form-group">
							Flat# : <br>
							<input type="text" name="flat#" required="required"> <br>
					</div>
					</div>
					
					<div class="col-md-4">
					<div class="form-group">
							Owner's Name : <br>
                            <input type="text" name="ownersName" required="required"> <br>
                    </div>
                    </div>
			</div>
            <div class="row">
                    <div class="col-md-4">
                    <div class="form-group">
							Age : <br>
							<input type="text" name="age" required="required"> <br>
					</div>
					</div>

					<div class="col-md-4">
					<div class="form-group">
							Contact No : <br>
							<input type="text" name="contactNo" required="required"> <br>
					</div>
					</div>
            </div>

            <div class="row">
					<div class="col-md-4">
					<div class="form-group">
							Email : <br>
							<input type="text" name="email" required="required"> <br>
					</div>
					</div>

					<div class="col-md-4">
					<div class="form-group">
							No of Members : <br>
							<input type="text" name="members" required="required"> <br>
					</div>
					</div>
            </div>

            <div class="row">
					<div class="col-md-4">
					<div class="form-group">
							Block : <br>
							<input type="text" name="block" required="required"> <br>
					</div>
					</div>

					<div class="col-md-4">
					<div class="form-group">
							Floor : <br>
							<input type="text" name="floor" required="required"> <br>
					</div>
					</div>
                </div>

            <div class="row">
					<div class="col-md-4">
					<div class="form-group">
							Flat Type : <br>
							<input type="text" name="type" required="required"> <br>
					</div>
					</div>
			
					<div class="col-md-4">
					<div class="form-group">
							Area : <br>
							<input type="text" name="area" required="required">
					</div>
					</div>
			</div>		 
			<br><br>

			<div class="row">
					<div class="col-md-4">
					<div class="form-group">
							<button type="submit" class="btn btn-success btn-lg" name="addpolicy"><a href="C:/Users/ACER/Desktop/sms/adminHome.html"></a>Add Policy</button>
					</div>
					</div>

					<div class="col-md-4">
					<div class="form-group">
							<button type="reset" class="btn btn-primary btn-lg" value="reset">Reset</button>
					</div>
					</div>
			</div>
		
		</form>	
			
	</div>
</body>
</html>