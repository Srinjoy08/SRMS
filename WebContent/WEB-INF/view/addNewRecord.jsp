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
<link rel="stylesheet" type="text/css" href="${css}boot.min.css">
<link rel="stylesheet" type="text/css" href="${css}style1.css">
<!-- END Spring Csss and Images -->
<style>
.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
<script>
$(function() {
  $("#dob").datepicker({
	  changeMonth:true,
	  changeYear:true,
	  maxDate:-1
  });
});
</script>
<body>
	<c:url var="logoutAction" value="/logout"></c:url>
	<style>
body {
	background-image: url("${img}background.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>
	<div class="container-fluid">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-dark"
				style="background-color: #000000; opacity: 0.7; margin-top: 5x;">


				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav mr-auto" style="text-align: center;">
						<a href="#name" style="color: whitesmoke"><h2>
								<b><marquee>Sunrise Apartments</marquee></b>
							</h2></a>


					</ul>
					<ul class="navbar-nav mr-auto" style="text-align: center;">
						<h4>
							<b>Welcome Arya</b>
						</h4>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item dropdown">

							<button class="btn btn-lg btn-secondary"
								onclick="window.location.href='/SRMS/adminHome'">Home</button>
							<button class="btn btn-lg btn-secondary"
								onclick="window.location.href='/SRMS/logout'">Logout</button>
						</li>

					</ul>
				</div>
			</nav>
		</div>
		<br>
		<style>
body {
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<div class="row">
					<h1 id="containers"
						style="color: cornflowerblue; font-family: Georgia, 'Times New Roman', Times, serif">
						<u>New User Addition Form</u>
					</h1>
				</div>
				<br>

				<c:if test="${check == 1}">
					<div class="alert">
						<span class="closebtn"
							onclick="this.parentElement.style.display='none';">&times;</span>
						<strong>Email Id Already Exists!</strong>
					</div>
					<br />
				</c:if>

				<form:form action="/SRMS/addNewResident" commandName="resident"
					method="post">

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								Owner's Name : <br>
								<form:input path="ownerName" type="text" name="ownerName"
									required="required" pattern="[A-Z]{1}[a-z]{3,}"
									title="Atleast 4 characters can be entered and the first character has to be Capital" />
								<br>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								No of Members : <br>
								<form:input path="noOfMembers" type="text" name="members"
									required="required" pattern="[1-9]\d{0,1}"
									title="Maximum 2 digits can be entered" />
								<br>
							</div>
						</div>

					</div>
					<div class="row">

						<div class="col-md-4">
							<div class="form-group">
								Gender : <br>
								<p style="padding-left: 70px">
									<form:input path="gender" type="radio" value="M"
										required="required" />
									Male <br>
									<form:input path="gender" type="radio" value="F"
										required="required" />
									Female <br>
								</p>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								Contact No : <br>
								<form:input path="contactNumber" type="text" name="contactNo"
									required="required" pattern="[1-9]\d{9}"
									title="Only 10 digits can be entered " />
								<br>
							</div>
						</div>
					</div>
					<div class="row">


						<div class="col-md-4">
							<div class="form-group">
								Email : <br>
								<form:input path="emailId" type="text" name="email"
									required="required" id="email"
									pattern="[A-Za-z0-9]{1,}@[a-z]{3,}\.[a-z]{2,}"
									title="Email id must have atleast one character before @ and atleast 3 characters before . followed by atleast 2 characters" />
								<br>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								Area : <br>
								<form:input path="area" type="text" name="area"
									required="required" pattern="[1-9]\d{2,3}"
									title="Area has to be number and 3 or 4 digits of length." />
							</div>
						</div>


					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="flatNo">Select Flat No:</label>
								<form:select class="form-control" path="flatNumber" id="flatNo"
									required="required">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
								</form:select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="block">Select Block No:</label>
								<form:select class="form-control" path="block" id="block"
									required="required">
									<form:option value="A">A</form:option>
									<form:option value="B">B</form:option>
									<form:option value="C">C</form:option>
									<form:option value="D">D</form:option>
								</form:select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="block">Select Floor No:</label>
								<form:select class="form-control" path="floorNumber" id="floor"
									required="required">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
								</form:select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="flatType" required="required">Select Flat
									Type:</label>
								<form:select path="flatType" class="form-control" id="flatType"
									required="required">
									<form:option value="1BHK">1BHK</form:option>
									<form:option value="2BHK">2BHK</form:option>
									<form:option value="3BHK">3BHK</form:option>
									<form:option value="4BHK">4BHK</form:option>
								</form:select>
							</div>
						</div>
					</div>

					<div class="row">


						<div class="col-md-4">
							<div class="form-group">
								Date of Birth : <br>
								<form:input path="dob" type="text" id="dob"
									readonly="true" required="required" placeholder="dd/mm/yyyy"/>
								<br>
							</div>
						</div>
					</div>
					<br>
					<br>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-lg"
									name="addpolicy">Add Data</button>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<button type="reset" class="btn btn-primary btn-lg"
									value="reset">Reset</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			
		</div>
	</div>
</body>
</html>