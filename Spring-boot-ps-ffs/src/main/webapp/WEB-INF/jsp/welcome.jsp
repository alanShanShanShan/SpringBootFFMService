<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="com.ps.model.*"%>
<%@page import="com.ps.service.FFMService"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sony PlayStation</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">


			<table>
				<form action="updateFF" method="post" modelAttribute="user" >
				
				<tr style ="font-size: 16px; background-color: #00008B; color: white; font-weight: bold;">
				<td colspan="6">Feature Flag Manager</td>
				
				</tr >
					<tr style ="font-size: 14px; color: #00008B; font-weight: bold;">
						<td>Region</td>
						<td>Asian</td>
						<td>Korea</td>
						<td>Europe</td>
						<td>Japan</td>
						<td>America</td>
					</tr>

					<tr>
						<td>Awesome Games</td>
						<%
						FFMService service = new FFMService();
							for (GAMEENUM iEnum : GAMEENUM.values()) {
						%>
						<td><input type="checkbox" class = "cBox" name=<%=iEnum.getName()%>
							<%if (service.isOn(iEnum)) {
					out.print("checked=\"checked\"");
				}%> />
						</td>

						<%
							}
						%>
					</tr>
					<td >New Features</td>
					<%
						for (FEATUREENUM iEnum : FEATUREENUM.values()) {
					%>
					<td><input type="checkbox" class = "cBox" name=<%=iEnum.getName()%>
						<%if (service.isOn(iEnum)) {
					out.print("checked=\"checked\"");
				}%> />
					</td>



					<%
						}
					%>
					</tr>
					<td>Identity Info</td>
					<%
						for (IDINFOENUM iEnum : IDINFOENUM.values()) {
					%>
					<td><input type="checkbox" class = "cBox" name=<%=iEnum.getName()%>
						<%if (service.isOn(iEnum)) {
					out.print("checked=\"checked\"");
				}%> />
					</td>

					<%
						}
					%>
					</tr>
					<tr>
						<td colspan="6" align = "right">
						<input type="reset"  value="Cancel" class = "reset" />
						<input type="submit" value="Save" class = "submit"/></td>
					</tr>
				</form>
			</table>

		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
