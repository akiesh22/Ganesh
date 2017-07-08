<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/simple-sidebar.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/jquery.dataTables.css"
	rel="stylesheet">
<script
	src="${ pageContext.request .contextPath }/resources/js/bootstrap.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery.dataTables.js"></script>
<title>Profile</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- Bank Form -->
			<div class="well">
				<h4 class="text-center">Bank Information</h4>
				<hr>
				<form class="form-horizontal"
					action="${pageContext.request.contextPath }/bank" method="post"
					model="bank">
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Bank
							Name:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bankName"
								placeholder="Bank Name" name="bankName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Branch
							Name:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="branchName"
								placeholder="Enter bank's branch name" name="branchName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Account
							Number:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="accNumber"
								placeholder="Enter your account number" name="accNumber">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Swift
							Code:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="swiftCode"
								placeholder="Enter swift code" name="swiftCode">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="#target1" type="submit"
								class="btn btn-default btn-success">Submit</button>
						</div>
					</div>
				</form>
			</div>
			<!-- Message -->
			<div class="well" id="messageWell">
				<div class="alert alert-success">
					<p id="successMessage">
						<strong>${message} success message</strong>
					</p>
				</div>
				<div class="alert alert-danger">
					<p id="errorMsg">
						<strong>${message} danger message</strong>
					</p>
				</div>
			</div>
			<!-- Bank Table -->
			<div class="well">
				<table id="myTable" class="table table-striped table-bordered">
					<thead>
					<tr>
							<th>Bank Name</th>
							<th>Branch Name</th>
							<th>Account Number</th>
							<th>Swift Number</th>
							<th>Operations</th>
					</tr>	
					</thead>
					<tbody>
						<tr>
							<td><p id="name"></p></td>
							<td><p id="branch"></p></td>
							<td><p id="account"></p></td>
							<td><p id="swift"></p></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$.ajax({
						type : "GET",
						contentType : "application/json",
						url : "${ pageContext.request.contextPath}/rest"
					}).then(
							function(result) {
								$.each(result, function(key, value) {
									$("#name").append(
											'<label>' + value.bankName
													+ '</label> <br/>');
									$("#branch").append(
											'<label>' + value.branchName
													+ '</label> <br/>');
									$("#account").append(
											'<label>' + value.accNumber
													+ '</label> <br/>');
									$("#swift").append(
											'<label>' + value.swiftCode
													+ '</label> <br/>');
								});
							});
				});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>
	<script type="text/javascript">
		$("#messageWell").hide();
	</script>
</body>
</html>