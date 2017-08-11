<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register|Students</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="<c:url value="/favicon.png"/>"
	type="image/png">
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap-theme.min.css"/>">
<link href="<c:url value="/style.css"/>" rel="stylesheet">
<script src="<c:url value="/evaluation_log.js"/>"></script>
</head>
<body>
	<div class="head">
		<img alt="" src="<c:url value="/logot.png"/>">
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
									<button data-toggle="modal"
										data-target="#myModalUpDate${student.id}" type="button"
										class="btn btn-primary">Edit</button>
									<div id="myModalUpDate${student.id}" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Edit student
														"${student.firstName} ${student.lastName}"</h3>
												</div>
												<div class="modal-body">
													<form id="Update" action="/university/students/update"
														method="post">
														<div class="form-group">
															<label for="inputFirstNameForUpdate">New first
																name</label> <input id="inputFirstNameForUpdate"
																name="updateStudentFirstName" required
																title="The subject name must consist of letters, whitespaces and - only"
																placeholder="Input new first name" class="form-control"
																type="text" pattern="^[a-zA-Z-\s]+$"
																oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
																oninput="this.setCustomValidity('')">
														</div>

														<div class="form-group">
															<label for="inputLastNameForUpdate">New last name</label>
															<input id="inputLastNameForUpdate"
																name="updateStudentLastName" required
																title="The subject name must consist of letters, whitespaces and - only"
																placeholder="Input new last name" class="form-control"
																type="text" pattern="^[a-zA-Z-]+$"
																oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
																oninput="this.setCustomValidity('')">
														</div>
														<hr>
														<div class="form-group">
															<input name="updateStudentId" class="form-control"
																type="hidden" value="${student.id}"> <input
																class="inputButton btn btn-default" type="submit"
																value="Update"> <input
																class="inputButton btn btn-default" type="button"
																data-dismiss="modal" value="Close"></input>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>

									<button data-toggle="modal"
										data-target="#myModalDelete${student.id}" type="button"
										class="btn btn-danger">Delete</button>
									<div id="myModalDelete${student.id}" class="modal fade">
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
																${student.lastName}"?</label> <input name="studentIdToDelete"
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
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="col-xs-3 col-xs-offset-1 col-md-3 hidden-xs hidden-sm">
				<div class="search">
					<h3>
						<img alt="" src="<c:url value="/logMarker.png"/>"> Search
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
					<a class="link visited" href="/university/students"><i
						class="glyphicon glyphicon-user"></i> students</a> <a
						href="/university/subjects"><i
						class="glyphicon glyphicon-book"></i> subjects</a> <a
						href="/university/marks"><i
						class="glyphicon glyphicon-piggy-bank"></i> marks</a> <a
						href="/university/acad-perfomance"><i
						class="glyphicon glyphicon-education"></i> progress</a>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/jquery-3.2.1.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.js"/>"></script>
	<c:if test="${exception!=null}">
		<div id="exceptionModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<br>
						<h3 class="modal-title">Attention</h3>
					</div>
					<div class="modBody modal-bod">
						<br>
						<h4 class="text-center">${exception}</h4>
						<br>
					</div>
					<div class="modal-footer">
						<div class="form-group">
							<input class="inputButton btn btn-default" type="button"
								data-dismiss="modal" value="Close"></input>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$('#exceptionModal').modal('show');
		</script>
	</c:if>
</body>
</html>