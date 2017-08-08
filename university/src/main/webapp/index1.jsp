<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register|Subjects</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.png" type="image/png">
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css">
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
					<button class="btn btn-primary" type="button" data-toggle="modal"
						data-target="#myModalAdd">Add subject</button>
					<div id="myModalAdd" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Add subject</h3>
								</div>
								<div class="modal-body">
									<form id="addSubject" action="/university/subjects/add"
										method="post">
										<input id="inputSubject" name="inputSubject"
											placeholder="Input name subject" class="form-control"
											type="text" pattern="^[a-zA-Z-]+$">
										<input type="submit" value="Add">
									</form>
								</div>
								<div class="modal-footer">
									<button class="btn btn-default" type="button"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<button data-toggle="modal" data-target="#myModalUpDate"
						type="button" class="btn btn-primary">Update subject</button>
					<div id="myModalUpDate" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Update subject</h3>
								</div>
								<div class="modal-body">
									<form id="Update">
										<div class="form-group">
											<label for="inputSubject">Name Subject</label> <input
												id="inputSubject" placeholder="Input name subject"
												class="form-control" type="text" pattern="^[a-zA-Z-]+$">
										</div>
										<div class="form-group">
											<label for="inputId">ID</label> <input id="inputId"
												placeholder="Input Id" class="form-control" type="number">
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button class="btn btn-default" type="button"
										data-dismiss="modal" form="Update" formaction="######"
										formmethod="post">Update</button>
									<button class="btn btn-default" type="button"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<button data-toggle="modal" data-target="#myModalDelete"
						type="button" class="btn btn-danger">Delete subject</button>
					<div id="myModalDelete" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Delete subject</h3>
								</div>
								<div class="modal-body">
									<form id="deleteSubject">
										<div class="form-group">
											<label for="inputId">ID</label> <input id="inputId"
												placeholder="Input Id" class="form-control" type="number">
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button class="btn btn-default" type="button"
										data-dismiss="modal" form="deleteSubject" formaction="######"
										formmethod="post">Delete</button>
									<button class="btn btn-default" type="button"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<table class="table table-bordered table-hover table-striped">
					<caption>
						<i class="glyphicon glyphicon-book"></i> subjects
						<hr>
					</caption>

					<thead>
						<tr>
							<th class="text-center">id</th>
							<th class="text-center">subject name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="subject" items="${subjects}">
							<tr>
								<td class="text-center">${subject.id}</td>
								<td class="text-center">${subject.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-xs-3 col-xs-offset-1  col-md-3 hidden-xs hidden-sm">
				<div class="search">
					<h3>
						<img alt="" src="logMarker.png"> Search
					</h3>
					<form class="form-horizontal">
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
								<label for="inputId" class="control-label">id</label> <input
									id="inputId" placeholder="Input Id" class="form-control"
									type="number">
							</p>
							<p>
								<label for="inputName">Name</label> <input id="inputName"
									placeholder="Input name" class="form-control" type="text"
									pattern="^[a-zA-Z-]+$">
							</p>

							<div class="col-sm-10 col-sm-offset-2">
								<button type="submit" class="btn btn-default">search</button>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="navigator">
					<h3>
						<img alt="" src="logMarker.png"> Navigation
					</h3>
					<a class="link" href="students.html"><i
						class="glyphicon glyphicon-user"></i> students</a> <a
						href="evaluation_log.html" class="visited"><i
						class="glyphicon glyphicon-book"></i> subjects</a> <a
						href="scores.html"><i class="glyphicon glyphicon-piggy-bank"></i>
						marks</a> <a href=""><i class="glyphicon glyphicon-education"></i>
						progress</a>
				</div>

			</div>
		</div>


	</div>
	<script src="jquery-3.2.1.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>