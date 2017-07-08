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
	src="${ pageContext.request.contextPath }/resources/js/jquery.js"></script>
<script
	src="${ pageContext.request .contextPath }/resources/js/bootstrap.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery.dataTables.js"></script>
<title>Profile</title>
<style>
  .modal-header, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
</head>
<body>
	<div class="fluid-container">
		<div class="col-md-6">
			<div class="well">
				<h4 class="text-center text-primary">Categories</h4>
				<hr>
				<div class="well">
					<h4 class="text-center text-primary">Add new Category</h4>
					<hr>

					<form action="addCategory" method="post" model="category">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span> <input id="name"
								type="text" required class="form-control input-lg text-primary"
								name="name" placeholder="Name of new Category">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="	glyphicon glyphicon-plus"></i></span> <input type="submit"
								class="form-control btn btn-success" value="Add"
								name="Add Category">
						</div>

					</form>
				</div>
				<div class="well">
					<p class="text-primary text-center">Added Category</p>
					<hr>
					<table class="table table-striped table-bordered"
						id="categoryTable">

						<thead>
							<tr>
								<th>Category Id</th>
								<th>Category Name</th>
								<th>Add Item</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="category" items="${catList}">
							<tr>
								<td>${category.id }</td>
								<td>${category.name }</td>
								<td><a href="${pageContext.request.contextPath}/addItem?id=${category.id}">Add</a></td>
								<td><a
									href="${pageContext.request.contextPath}/viewItem?id=${category.id}">View
										Items</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>

		<div class="col-md-6">
			<div class="well">
				<h4 class="text-center text-Primary">Item</h4>
				<hr>
				<div class="well">
					<table id="itemTable">

						<thead>
							<tr>
								<th>Id</th>
								<th>Item Name</th>
								<th>Description</th>
								<th>Post By</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="item" items="${itemList}">
							<tr>
								<td>${item.id }</td>
								<td>${item.name }</td>
								<td>${item.desc }</td>
								<td>${item.postBy}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
				<%@ include file="addItem.jsp"%>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#categoryTable').DataTable();
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#itemTable').DataTable();
		});
	</script>
</body>
</html>