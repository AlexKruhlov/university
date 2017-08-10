<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register|Students</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.png" type="image/png">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<script src="evaluation_log.js"></script>
</head>
<body>
	<div class="head">
		<img alt="" src="logot.png">
	</div>

	<div class="container-fluid">

		<div class="row-fluid">
			<div class="size col-xs-7 col-xs-offset-1">

				<div class="buttons">
					<button class="green btn" type="button" data-toggle="modal"
						data-target="#myModalAdd">Add student</button>
					<div id="myModalAdd" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Add student</h3>
								</div>
								<div class="modal-body">
									<form id="addStudent" action="/university/students/add"
										method="post">
										<div class="form-group">
											<label for="inputFirstName">First name</label> <input
												id="inputFirstName" name="addStudentFirstName" required
												title="The subject name must consist of letters, whitespaces and - only"
												placeholder="Input first name" class="form-control"
												type="text" pattern="^[a-zA-Z-]+$"
												oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
												oninput="this.setCustomValidity('')">
										</div>
										<div class="form-group">
											<label for="inputFirstName">Last name</label> <input
												id="inputFirstName" name="addStudentLastName" required
												title="The subject name must consist of letters, whitespaces and - only"
												placeholder="Input last name" class="form-control"
												type="text" pattern="^[a-zA-Z-]+$"
												oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
												oninput="this.setCustomValidity('')">
										</div>
										<div class="form-group">
											<input class="inputButton btn btn-default" type="submit"
												value="Add"> <input
												class="inputButton btn btn-default" type="button"
												data-dismiss="modal" value="Close"></input>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>


				<hr>
				<table class="table table-bordered table-hover">
					<caption>
						<i class="glyphicon glyphicon-user"></i> students
						<hr>
					</caption>

					<thead>
						<tr>
							<th class="text-center" style="width: 7%"></th>
							<th class="text-center" style="width: 30%">first name</th>
							<th class="text-center" style="width: 30%">first name</th>
							<th class="text-center" style="width: 33%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${students}" varStatus="loop">
							<tr>
								<td class="text-center">${loop.index+1}</td>
								<td class="text-center">${student.firstName}</td>
								<td class="text-center">${student.lastName}</td>
								<td>
								
								<button data-toggle="modal" data-target="#myModalUpDate"
										type="button" class="btn btn-primary btTable">Update name</button>
									<div id="myModalUpDate" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Update student</h3>
												</div>
												<div class="modal-body">
													<form id="Update" action="/university/students/update"
														method="post">
														<div class="form-group">
															<label for="inputIdDeleteStudent">ID</label> <input
																id="inputIdDeleteStudent" name="updateStudentId"
																placeholder="Input student Id" class="form-control"
																type="number">
														</div>
														<div class="form-group">
															<label for="inputFirstNameForUpdate">New first
																name</label> <input id="inputFirstNameForUpdate"
																name="updateStudentFirstName"
																placeholder="Input new first name" class="form-control"
																type="text" pattern="^[a-zA-Z-\s]+$"
																oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
																oninput="this.setCustomValidity('')">
														</div>

														<div class="form-group">
															<label for="inputLastNameForUpdate">New last name</label>
															<input id="inputLastNameForUpdate"
																name="updateStudentLastName"
																placeholder="Input new last name" class="form-control"
																type="text" pattern="^[a-zA-Z-]+$"
																oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
																oninput="this.setCustomValidity('')"> <input
																class="inputButton btn btn-default" type="submit"
																value="Update">
														</div>
													</form>
												</div>
												<div class="modal-footer">
													<button class="btn btn-default" type="button"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>

								
								
								
								
								
								<button data-toggle="modal"
										data-target="#myModalDelete" type="button"
										class="btn btn-danger">Delete student</button>
									<div id="myModalDelete" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Delete student</h3>
												</div>
												<div class="modal-body">
													<form id="deleteStudent"
														action="/university/students/delete" method="post">
														<div class="form-group">
															<label for="inputIdForDelete">Do you really want
																to delete the "${student.firstName}
																${student.lastName}"?</label> <input
																class="inputButton btn btn-default" type="hidden"
																value="${student.id}">
														</div>
														<hr>
														<div class="form-group">
															<input class="inputButton btn btn-default" type="submit"
																value="Delete"> <input
																class="inputButton btn btn-default" type="button"
																data-dismiss="modal" value="Close"></input>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="col-xs-3 col-xs-offset-1 col-md-3 hidden-xs hidden-sm">
				<div class="search">
					<h3>
						<img alt="" src="logMarker.png"> Search
					</h3>
					<form class="form-horizontal" action="####" method="post">
						<fieldset>
							<p>
								<label for="selectRegister" class="control-label">select
									register</label> <select id="selectRegister" class="form-control">
									<option>...</option>
									<option>students</option>
									<option>subjects</option>
									<option>marks</option>
									<option>progress</option>
								</select>
							</p>
							<p>
								<label for="inputIdForSearch" class="control-label">id</label> <input
									id="inputIdForSearch" placeholder="Input Id"
									class="form-control" type="number">
							</p>
							<p>
								<label for="inputNameForSearch">Name</label> <input
									id="inputNameForSearch" placeholder="Input name"
									class="form-control" type="text" pattern="^[a-zA-Z-]+$">
							</p>

							<div class="col-sm-12 col-sm-offset-4">
								<input class="inputButton btn btn-default" type="submit"
									value="Search">
							</div>
						</fieldset>
					</form>
				</div>
				<div class="navigator">
					<h3>
						<img alt="" src="logMarker.png"> Navigation
					</h3>
					<a class="link" href="/university/students"><i
						class="glyphicon glyphicon-user"></i> students</a> <a
						href="/university/subjects" class="visited"><i
						class="glyphicon glyphicon-book"></i> subjects</a> <a
						href="/university/marks"><i
						class="glyphicon glyphicon-piggy-bank"></i> marks</a> <a
						href="/university/progres"><i
						class="glyphicon glyphicon-education"></i> progress</a>
				</div>
			</div>
		</div>
	</div>
	<script src="jquery-3.2.1.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>