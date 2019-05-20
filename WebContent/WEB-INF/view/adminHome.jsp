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
		<div class="col-sm-5"></div>
		<div class="col-sm-3"></div>
		<div class="col-sm-2">
			<form action="/SRMS/addNewResidentPage"
				id="btnform2">
				<button type="submit" id="addpro" class="btn">
					<span>Add New Resident Information</span>
				</button>
			</form>
		</div>
			
	</div>

	<div style="margin-left: 100px">
		<div class="col-md-12">
			<table class="table table-striped " style="text-align: center">
				<thead>
					<tr>
						<th scope="col">Flat#</th>
						<th scope="col">Owner's Name</th>
						<th scope="col">DOB</th>
						<th scope="col">Gender</th>
						<th scope="col">Contact No</th>
						<th scope="col">Email</th>
						<th scope="col">Number of Members</th>
						<th scope="col">Block</th>
						<th scope="col">Floor</th>
						<th scope="col">Flat Type</th>
						<th scope="col">Area</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${residentList}" var="resident">
						<tr>
							<td scope="row">${resident.flatNumber}</td>
							<td>${resident.ownerName}</td>
							<td>${resident.dob}</td>
							<td>${resident.gender}</td>
							<td>${resident.contactNumber}</td>
							<td>${resident.emailId}</td>
							<td>${resident.noOfMembers}</td>
							<td>${resident.block}</td>
							<td>${resident.floorNumber}</td>
							<td>${resident.flatType}</td>
							<td>${resident.area}</td>
							<td colspan="2"><button class="btn btn-warning btn-sm">
									<a href="/SRMS/editResidentPage/${resident.id}">Edit</a>
								</button>&nbsp;&nbsp;
								<button class="btn btn-danger btn-sm">
									<a href="/SRMS/removeResident/${resident.id}">Remove</a>
								</button>&nbsp;&nbsp;
								<button class="btn btn-success btn-sm">
									<a href="/SRMS/generateBill/${resident.id}">Generate
										Bill</a>
								</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>