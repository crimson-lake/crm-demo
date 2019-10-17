<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<th>${tempCustomer.firstName}</th>
						<th>${tempCustomer.lastName}</th>
						<th>${tempCustomer.email}</th>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
	
</body>
</html>