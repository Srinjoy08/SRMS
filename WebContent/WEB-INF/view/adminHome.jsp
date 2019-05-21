<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Homepage</title>
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
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setIntHeader("Refresh", (10*60));
	%>
	<c:if test="${user eq null }">
		<%response.sendRedirect("/SRMS/loginAdminPage"); %>
	</c:if>
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
							<b>Welcome ${user.firstName} ${user.lastName}</b>
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
#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

body {
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>

		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-3">

				<input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Search for names.." title="Type in a name">
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">

				<form action="/SRMS/billListPage" id="btnform2">
					<button type="submit" style="margin-top: 10px;
                        margin-left: 20px;
                     margin-bottom: 50px;
                        border-radius: 2.5rem;
                        background-color: #7e7e7e;
                        width: 100%;
                        color: white;
                        font-size: 20px;" class="btn" style="height: 50px;"><span>View Bills</span></button>

				</form>
			</div>

			<div class="col-md-1"></div>
			<div class="col-md-2">
				<form action="/SRMS/addNewResidentPage" id="btnform2">
					<button type="submit" id="addpro" class="btn" style="height: 50px;">
						Add New Resident</button>
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
							<th scope="col">DOB</th>
							<th scope="col">Gender</th>
							<th scope="col">Contact No</th>
							<th scope="col">Email</th>
							<th scope="col">Number of Members</th>
							<th scope="col">Block</th>
							<th scope="col">Floor</th>
							<th scope="col">Flat Type</th>
							<th scope="col">Area <br/>(sq.ft.)</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${residentList}" var="resident">
							<tr style="background-color: cadetblue">
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
								<td colspan="2"><button class="btn-sm" style="color: black">
										<a href="/SRMS/editResidentPage/${resident.id}"
											style="font-color: red;"><b>Edit</b></a>
									</button>&nbsp;&nbsp;
									<button class="btn-sm" style="color: black">
										<a href="/SRMS/removeResident/${resident.id}"><b>Remove</b></a>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			// Declare variables 
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");

			// Loop through all table rows, and hide those who don't match the search query
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>

</body>
</html>