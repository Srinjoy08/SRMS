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
<body>
	<c:url var="logoutAction" value="/logout"></c:url>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark"
			style="background-color: #000000; opacity: 0.7; margin-top: 5x;">


			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav mr-auto" style="text-align: center;">
					<a href="#name"><h2>
							<b><marquee>Welcome to Sunkiss Apartments</marquee></b>
						</h2></a>


				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown">

						<button class="btn btn-lg btn-secondary"
							onclick="window.location.href='${logoutAction}'">Logout</button>

					</li>

				</ul>
			</div>
		</nav>
	</div>
	<style>
body {
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>
	<div class="row">
		<div class="col-md-3"></div>
		<!--Input Fields begins here-->
		<div class="col col-md-offset-2 col-md-6">
			<div class="row">
				<h1 id="containers">
					<u>New Resident Addition Form</u>
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
			<div class="row">
				<div class="col col-md-offset-2 col-md-12">
					<form:form action="/SRMS/addNewResident" commandName="resident"
						method="post">

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									Owner's Name : <br>
									<form:input path="ownerName" type="text" name="ownerName"
										required="required" />
									<br>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									Date of Birth : <br>
									<form:input path="dob" type="text" name="ownersName"
										class="date-picker" required="required" />
									<br>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-4">
								<div class="form-group">
									Gender : <br>
									<p style="padding-left: 70px">
										<form:input path="gender" type="radio" value="M" />
										Male <br>
										<form:input path="gender" type="radio" value="F" />
										Female <br>
									</p>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-4">
								<div class="form-group">
									Contact No : <br>
									<form:input path="contactNumber" type="number" name="contactNo"
										required="required" />
									<br>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									Email : <br>
									<form:input path="emailId" type="text" name="email"
										required="required" />
									<br>
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
									No of Members : <br>
									<form:input path="noOfMembers" type="text" name="members"
										required="required" />
									<br>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									Area : <br>
									<form:input path="area" type="text" name="area"
										required="required" />
								</div>
							</div>
						</div>
						<br>
						<br>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<button type="submit" class="btn btn-success btn-lg"
										name="addpolicy">Add</button>
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
		<div class="col-md-3"></div>
	</div>
</body>
</html>