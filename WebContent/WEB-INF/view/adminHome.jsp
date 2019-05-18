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
		<div class="col-sm-2">
			<form action="C:/Users/ACER/Desktop/sms/addNewRecord.html" id="btnform2">`
				<button type="submit" id="addpro" class="btn" style="margin-left: 1200px"><span>Add Policy</span></button>
			</form>
		</div>

		<div style="margin-left: 100px">
			<div class="col-md-12">
				<table class="table table-striped " style="text-align: center" >
					<thead>
					  <tr>
							<th scope="col">Flat#</th>
							<th scope="col">Owner's Name</th>
							<th scope="col">Age</th>
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
					  <tr>
							<td scope="row">1</td>
							<td>Arya</td>
							<td>22</td>
							<td>8240200898</td>
							<td>aryadsgupta@gmail.com</td>
							<td>1</td>
							<td>1</td>
							<td>4</td>
							<td>2BHK</td>
							<td>876 sq.ft</td>
							<td colspan="2"><button class="btn btn-warning btn-sm"><a  href="C:/Users/ACER/Desktop/sms/editRecord.html">Edit</a></button>&nbsp;&nbsp;
							 	<button  class="btn btn-danger btn-sm"><a href="C:/Users/ACER/Desktop/sms/adminHome.html">Remove</a></button></td>
					  </tr>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>
