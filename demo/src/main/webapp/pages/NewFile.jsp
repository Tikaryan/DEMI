<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$(window)
								.load(
										function()
										{
											$('#addTblId').hide();

											$.ajax
											({
												type : "POST",
												url : "getAllEmployeeNAme.html",
												dataType : "json",
												success : function(List) 
												{
													$.each(List,function(i,item) 
															{
														$('#body').append('<tr><td value="item"></td></tr>');
															});
												}
											})

										});

						$('#addId').on('click', function() {

							$('#addTblId').show();
							$("#addId").hide();
						});

						$.fn.addRows = function() {
							$lastTr = $('#addTblId').find("tr:last");
							$lastTr.remove();

							$laTr = $('#addTblId').find("tr:last");
							$clonedTr = $laTr.clone();
							$clonedTr.insertAfter($laTr);
							$lastTr.insertAfter($clonedTr);
						}

						$(document).on(
								'click',
								'#submit',
								function() {

									if (null == $('#firstNameId').val()
											|| '' == $('#firstNameId').val()) {
										$('#firstNameId').css("border-color",
												"red");
										alert("First Name is mendatory");
										event.preventDefault();
									}

								})

					});
</script>
</head>
<body>
	<table>
		<tr>
			<td><input type="button" value="Add Employee" id="addId"></td>
			<td><input type="button" value="List of  Employee" id="listId"></td>
		</tr>
	</table>
	<form:form action="/save" modelAttribute="employeeDO">
		<table id="addTblId">
			<tr>
				<td>FIRST-NAME</td>
				<td>Email</td>
				<td>CONTACTNO.</td>
				<td>Status</td>
				<td><input value="Add" type="button"
					onclick="$(this).addRows()"></td>
				<td align="right"><a href="#" id="delete"><img
						src="/resources/images/delete.png" height="10" width="10"
						align="absmiddle" /></a></td>
				<td></td>
			</tr>
			<tr id="addTrId">

				<td><input placeholder="Id" readonly="true"
					style="display: none;"> <form:input path="firstName"
						placeholder="First-Name" id="firstNameId"></form:input></td>
				<td><form:input path="email" placeholder="Email"></form:input></td>
				<td><form:input path="contactNo" placeholder="Contact-No"></form:input></td>
				<td><form:select path="status">
						<form:option value="">Select</form:option>
						<form:option value="active">Active</form:option>
						<form:option value="inactive">Inactive</form:option>
					</form:select></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="SAVE" id="submit"></td>
			</tr>
		</table>
		<table frame="box">
			<tbody id="body">
			</tbody>
		</table>
	</form:form>
</body>
</html>