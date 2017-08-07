<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<script src="evaluation_log.js"></script>
</head>
<body>
	<div class="head"></div>
	<div class="container-fluid">
		<div class="row">
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
									<div class="form-group">
										<form id="addSubject" method="post">
											<label for="inputSubject">Name Subject</label> <input name="inputSubject"
												  id="inputSubject" placeholder="Input name subject"
												class="form-control" type="text" pattern="^[a-zA-Z-]+$">
											<button formaction="/university/subjects/add">Add</button>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button class="btn btn-default" type="submit"
										data-dismiss="modal" form="addSubject"
										formaction="/university/subjects" formmethod="get">Add</button>
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
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<table class="table table-bordered table-hover table-striped">
					<caption>
						subjects
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
								<th>${subject.id}</th>
								<th>${subject.name}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-xs-3 col-xs-offset-1">
				<div>
					<h3>Navigation</h3>
					<a class="link" href=""><i class="glyphicon glyphicon-user"></i>
						students</a> <a href=""><i class="glyphicon glyphicon-piggy-bank"></i>
						score</a> <a href=""><i class="glyphicon glyphicon-education"></i>
						progress</a>
				</div>
			</div>
		</div>
	</div>
	<script src="jquery-3.2.1.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>