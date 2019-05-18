<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<spring:url value="/res/styles/" var="css" />
<spring:url value="/res/scripts/" var="js" />
<spring:url value="/res/images/" var="img" />
<!-- Start Css-->
<link rel="stylesheet" type="text/css" href="${css}bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${css}styles/custom.css">



<!-- End  Css -->
<style>
body {
	background-image: url("${img}society-management-software.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
}
</style>

</head>
<body>

	<div class="verticle-center">
		<div class="container">
			<div class="row">
				<div class="display-flex">
					<div class="col-lg-7 col-md-6">

						<h2 class="display-3">Login</h2>
						<p class="pg">Welcome to Sunkiss Society, please provide your
							login credentials.</p>
						<form action="C:/Users/ACER/Desktop/sms/adminHome.html"
							method="post">

							<div class="form-group">
								<input type="text" name="id" required="required"
									autocomplete="off" placeholder="ID" />
							</div>
							<div class="form-group">
								<input type="password" required="required" autocomplete="off"
									placeholder="password" id="myInput" /></br> <input type="checkbox"
									onclick="myFunction()" name="checkbox" />Show Password

							</div>

							<div class="button-group"></div>
							<button type="submit" class="btn btn-info btn-new-bg btn-lg">LOGIN</button>
							<br>
						</form>
					</div>
				</div>
			</div>

			<script>
				function myFunction() {
					var x = document.getElementById("myInput");
					if (x.type === "password") {
						x.type = "text";
					} else {
						x.type = "password";
					}
				}
			</script>
		</div>
	</div>
</body>
</html>