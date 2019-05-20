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
body {
	background-image: url("${img}background.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>
</head>
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
		<div class="col-sm-5"></div>
		<div class="col-sm-3"></div>
		<div class="col-sm-2">
			<form action="/SRMS/generateBill"
				id="btnform2">
				<button type="submit" id="addpro" class="btn" style="height: 70px;">
					<span>Generate Bill for this Month</span>
				</button>
				
			</form>
		</div>
			
	</div>

<div class="row" style="margin: 10px;">
			<div class="col-md-12">
				<table class="table table-striped " style="text-align: center"
					id="myTable">
					<thead>
						<tr style="background-color: cadetblue">
						<th scope="col">Flat#</th>
						<th scope="col">Owner's Name</th>
						<th scope="col">Contact No</th>
						<th scope="col">Email</th>
						<th scope="col">Block</th>
						<th scope="col">Floor</th>
						<th scope="col">Flat Type</th>
						<th scope="col">Area</th>
						<th scope="col">Billing Month</th>
						<th scope="col">Billing Year</th>
						<th scope="col">Bill Amount</th>
						<th scope="col">Bill Status</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${billList}" var="bill">
						<tr style="background-color: cadetblue">
							<td scope="row">${bill.flatNumber}</td>
							<td>${bill.ownerName}</td>
							<td>${bill.contactNumber}</td>
							<td>${bill.emailId}</td>
							<td>${bill.block}</td>
							<td>${bill.floorNumber}</td>
							<td>${bill.flatType}</td>
							<td>${bill.area}</td>
							<td>${bill.month}</td>
							<td>${bill.year}</td>
							<td>${bill.billAmount}</td>
							<td>${bill.billStatus}</td>
							<td colspan="2"><button class="btn-sm" style="color: black">
									<a href="/SRMS/payBill/${bill.id}" style="font-color:red;"><b>Mark As Paid</b></a>
								</button>&nbsp;&nbsp;
								<button class="btn-sm" style="color: black"">
									<a href="/SRMS/mailBill/${bill.id}"><b>Mail Bill</b></a>
								</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>
</html>