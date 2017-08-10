<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register|Subjects</title>

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
						data-target="#myModalAdd">Add subject</button>
					<div id="myModalAdd" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title">Add subject</h3>
								</div>
								<div class="modal-body">
									<form id="addSubject" name="addSubject"
										action="/university/subjects/add" method="post">
										<div class="form-group">
											<label for="inputSubject">Subject Name</label> <input
												id="inputSubject" name="addSubjectName"
												placeholder="Input subject name" class="form-control"
												type="text" pattern="^[a-zA-Z- ]+$"
												oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
												oninput="this.setCustomValidity('')">
										</div>
										<hr>
										<div class="form-group">
											<c:catch var="catchException">
												<input class="inputButton btn btn-default" type="submit"
													value="Add">
											</c:catch>
											<c:if test="${catchException != null}">
												<p>
													The exception is : ${catchException} <br /> There is an
													exception: ${catchException.message}
												</p>
											</c:if>

											<input class="inputButton btn btn-default exsit"
												type="button" data-dismiss="modal" value="Close"></input>
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
						<i class="glyphicon glyphicon-book"></i> subjects
						<hr>
					</caption>
					<thead>
						<tr>
							<th class="text-center" style="width: 7%"></th>
							<th class="text-center" style="width: 58%">subject name</th>
							<th class="text-center" style="width: 35%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="subject" items="${subjects}" varStatus="loop">
							<tr>
								<td class="text-center">${loop.index+1}</td>
								<td class="text-center">${subject.name}</td>
								<td><button data-toggle="modal"
										data-target="#myModalUpDate${subject.id}" type="button"
										class="btn btn-primary">Edit</button>
									<button data-toggle="modal"
										data-target="#myModalDelete${subject.id}" type="button"
										class="btn btn-danger">Delete</button></td>
							</tr>
							<div id="myModalUpDate${subject.id}" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h3 class="modal-title">Edit subject</h3>
										</div>
										<div class="modal-body">
											<form id="Update" action="/university/subjects/update"
												method="post">
												<div class="form-group">
													<label class="sizeLabel" for="inputSubject">Rename
														${subject.name} to</label> <input id="inputSubject"
														name="updateSubjectName" class="form-control" type="text"
														pattern="^[a-zA-Z- ]+$"
														oninvalid="this.setCustomValidity('The subject name must consist of letters, whitespaces and - only')"
														oninput="this.setCustomValidity('')">
												</div>
												<input name="updateSubjectId" class="form-control"
													type="hidden" value="${subject.id}">
												<div class="form-group"></div>
												<hr>
												<div class="form-group">
													<input class="inputButton btn btn-default" type="submit"
														value="Save"> <input
														class="inputButton btn btn-default exsit" type="button"
														data-dismiss="modal" value="Close"></input>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>

							<div id="myModalDelete${subject.id}" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h3 class="modal-title">Delete subject</h3>
										</div>
										<div class="modal-body">
											<form id="deleteSubject" action="/university/subjects/delete"
												method="post">
												<div class="form-group">
													<label class="sizeLabel">Do you really want to
														delete the "${subject.name}"?</label> <input
														class="inputButton btn btn-default" name="deleteSubject"
														type="hidden" value="${subject.id}">
												</div>
												<hr>
												<div class="form-group">
													<input class="inputButton btn btn-default" type="submit"
														value="Delete"> <input
														class="inputButton btn btn-default exsit" type="button"
														data-dismiss="modal" value="Close"></input>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
				</ul>
			</div>
			<div class="col-xs-3 col-xs-offset-1  col-md-3 hidden-xs hidden-sm">
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
								<label for="inputId" class="control-label">id</label> <input
									id="inputId" placeholder="Input Id" class="form-control"
									type="number">
							</p>
							<p>
								<label for="inputName">Name</label> <input id="inputName"
									placeholder="Input name" class="form-control" type="text"
									pattern="^[a-zA-Z-]+$">
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
	<script src="<c:url value="/jquery-3.2.1.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.js"/>"></script>
	<c:if test="${exception!=null}">
		<script type="text/javascript">
		
		</script>
	</c:if>

</body>
</html>