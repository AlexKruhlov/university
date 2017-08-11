<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register|Progress</title>
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
						data-target="#myModalAdd">Add mark</button>
					<div id="myModalAdd" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Add mark</h3>
								</div>
								<div class="modal-body">
									<form id="addMark" action="/university/acad-perfomance/add"
										method="post">
										<div class="form-group">
											<p>
												<label for="inputFirstNameStud">First name student</label> <input
													id="inputFirstNameStud"
													placeholder="Input first name Student" name="addFirstName"
													required
													title="The subject name must consist of letters, whitespaces and - only"
													class="form-control" type="text" pattern="^[a-zA-Z-]+$">
											</p>
											<p>
												<label for="inputLastNameStud">Last name student</label> <input
													id="inputLastNameStud"
													placeholder="Input last name Student" name="addLastName"
													required
													title="The subject name must consist of letters, whitespaces and - only"
													class="form-control" type="text" pattern="^[a-zA-Z-]+$">
											</p>
											<p>
												<label for="inputMark" class="control-label">Mark</label> <input
													id="inputMark" placeholder="Input mark" name="addMarkValue"
													class="form-control" type="number">
											</p>
											<p>
												<label for="selectSubject" class="control-label">Select
													subject</label> <select id="selectSubject" class="form-control"
													name="addSubject">
													<option>all</option>
													<c:forEach var="subject" items="${subjects}">
														<option>${subject.name}</option>
													</c:forEach>
												</select>
											</p>
										</div>

										<div class="form-group">
											<label for="inputDate">Select date:</label> <input
												name="addDate" type="date" class="form-control">
										</div>
										<hr>
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

					<hr>

					<h1 class="caption">
						<i class="glyphicon glyphicon-education"></i> progress
						<hr>
					</h1>

					<div class="searchMarks">
						<h3 class="succsses">Academic Performance</h3>
						<form role="form" class="form-inline">
							<div class="form-group nameStud">
								<label class="label" for="inputFirstNameStudent">First
									name student</label> <input id="inputFirstNameStudent"
									placeholder="Input first name Student" name="addFirstNameStud"
									required
									title="The subject name must consist of letters, whitespaces and - only"
									class="form-control" type="text" pattern="^[a-zA-Z-]+$">
							</div>
							<div class="form-group nameStudLeft">
								<label class="label" for="inputLastNameStudent">Last
									name student</label> <input id="inputLastNameStudent"
									placeholder="Input last name Student" name="addFirstNameStud"
									required
									title="The subject name must consist of letters, whitespaces and - only"
									class="form-control" type="text" pattern="^[a-zA-Z-]+$">
							</div>

							<div class="block">
								<div class="col-xs-6">
									<div class="input-group">
										<span class="input-group-addon">Select subject <input
											type="radio" name="select">
										</span> <select id="selectSubjectForSucsses" class="form-control">
											<option>all</option>
											<option>history</option>
											<option>musick</option>
											<option>chemestry</option>
											<option>photo</option>
										</select>
									</div>
								</div>

								<div class="col-xs-6">
									<div class="input-group">
										<span class="input-group-addon">Select date <input
											type="radio" name="select">
										</span>
										<form>
											<div class="form-group">
												<input type="date" class="form-control">
											</div>
										</form>
									</div>
								</div>
								<button type="submit" class="btn btn-success">Search</button>
							</div>
						</form>
					</div>
					<table class="table table-bordered table-hover">
						<caption>Mark Barton</caption>

						<thead>
							<tr>
								<th class="text-center" style="width: 7%"></th>
								<th class="text-center" style="width: 30%">date</th>
								<th class="text-center" style="width: 30%">mark</th>
								<th class="text-center" style="width: 33%"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">1</td>
								<td class="text-center">12.08.2017</td>
								<td class="text-center">10</td>
								<td class="text-center">
									<button data-toggle="modal" data-target="#myModalUpDateTabOne"
										type="button" class="btn btn-primary">Edit</button>
									<div id="myModalUpDateTabOne" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Edit mark</h3>
												</div>
												<div class="modal-body">
													<form id="UpdateTabOne" action="####" method="post">
														<div class="form-group">
															<label for="UpdateTabOne">Name mark</label> <input
																id="inputNameMark" name="editMarkTabOne"
																placeholder="Input name mark" required
																title="The subject name must consist of letters, whitespaces and - only"
																class="form-control" type="text" pattern="^[a-zA-Z-]+$">
														</div>
														<hr>
														<div class="form-group">
															<input class="inputButton btn btn-default" type="submit"
																value="Edit"> <input
																class="inputButton btn btn-default" type="button"
																data-dismiss="modal" value="Close"></input>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>



									<button data-toggle="modal" data-target="#myModalDeleteTabOne"
										type="button" class="btn btn-danger">Delete</button>
									<div id="myModalDeleteTabOne" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Delete mark</h3>
												</div>
												<div class="modal-body">
													<form id="deleteMarkTabOne" action="####" method="post">
														<div class="form-group">
															<label>Do you really want to delete the?</label>
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
						</tbody>
					</table>




					<table class="table table-bordered table-hover">
						<caption>Mark Barton</caption>

						<thead>
							<tr>
								<th class="text-center" style="width: 7%"></th>
								<th class="text-center" style="width: 30%">subject</th>
								<th class="text-center" style="width: 30%">mark</th>
								<th class="text-center" style="width: 33%"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">1</td>
								<td class="text-center">history</td>
								<td class="text-center">10</td>
								<td class="text-center">
									<button data-toggle="modal" data-target="#myModalUpDate"
										type="button" class="btn btn-primary">Edit</button>
									<div id="myModalUpDate" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Edit mark</h3>
												</div>
												<div class="modal-body">
													<form id="UpdateProgress" action="####" method="post">
														<div class="form-group">
															<label for="inputNameMark">Name mark</label> <input
																id="inputNameMark" name="editMark"
																placeholder="Input name mark" required
																title="The subject name must consist of letters, whitespaces and - only"
																class="form-control" type="text" pattern="^[a-zA-Z-]+$">
														</div>
														<hr>
														<div class="form-group">
															<input class="inputButton btn btn-default" type="submit"
																value="Edit"> <input
																class="inputButton btn btn-default" type="button"
																data-dismiss="modal" value="Close"></input>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>



									<button data-toggle="modal" data-target="#myModalDelete"
										type="button" class="btn btn-danger">Delete</button>
									<div id="myModalDelete" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title">Delete mark</h3>
												</div>
												<div class="modal-body">
													<form id="deleteMark" action="####" method="post">
														<div class="form-group">
															<label>Do you really want to delete the?</label>
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
						</tbody>
					</table>




				</div>
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
						<img alt="" src="<c:url value="/logMarker.png"/>"> Navigation
					</h3>
					<a class="link" href="/university/students"><i
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
</body>
</html>