<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logging out...</title>
	<style>
		.loader {
			  margin-left: 50%;
			  border: 16px solid #f3f3f3;
			  border-radius: 50%;
			  border-top: 16px solid #3498db;
			  width: 50px;
			  height: 50px;
			  -webkit-animation: spin 1s linear infinite; /* Safari */
			  animation: spin 1s linear infinite;
		}
		
		/* Safari */
		@-webkit-keyframes spin {
			  0% { -webkit-transform: rotate(0deg); }
			  100% { -webkit-transform: rotate(360deg); }
		}
		
		@keyframes spin {
			  0% { transform: rotate(0deg); }
			  100% { transform: rotate(360deg); }
		}
		</style>
		<script>
			function redir() {
				location = "/SRMS/loginAdminPage";
			}
		</script>
</head>
<body>
	<body onload="setTimeout(redir, 3000);">
		<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		%>
		<c:if test="${user eq null}">
			<%response.sendRedirect("/SRMS/loginAdminPage"); %>
		</c:if>
		<%session.setAttribute("user", null); %>
		<% session.invalidate(); %>
		<br><br><br><br><br><br>
		<p style="padding-left: 43%;"><b>You are now logged out!! Please wait for 3 seconds</b></p>
		<br>
		<div class="loader"></div>
	</body>
</body>
</html>