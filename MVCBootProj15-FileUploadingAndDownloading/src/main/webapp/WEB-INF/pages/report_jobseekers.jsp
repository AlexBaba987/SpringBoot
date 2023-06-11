<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color:red;text-align:center">JobSeeker Record</h1>
<c:choose>
	<c:when test="${!empty jsInfo}">
		<table align="center" bgcolor="cyan" border="1">
			<tr bgcolor="green">
				<th>JsId</th><th>Name</th><th>Address</th><th>Download-Resume</th><th>Download-photo</th>
			</tr>
			<c:forEach var="js" items="${jsInfo}">
				<tr>
					<td>${js.jsId}</td>
					<td>${js.jsName}</td>
					<td>${js.jsAddrs}</td>
					<td><a href="js_download?id=${js.jsId}&type=resume">download</a></td>
					<td><a href="js_download?id=${js.jsId}&type=photo">download</a><img src="${js.photoPath}" width="40" height="40"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
			<h1 style="color:green;text-align:center">No Record</h1>
	</c:otherwise>
</c:choose>

<center>
<h3><a href="./">home</a></h3>
</center>