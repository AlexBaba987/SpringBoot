<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<c:choose>
	<c:when test="${!empty empsList}">
	<h1 style="color:red;text-align:center"> <u>Employees Report</u></h1>
	</br>
	<table border="1" align="center">
		<tr style="color:red"><th>empno</th><th>ename</th><th>job</th><th>salary</th><th>deptno</th><th>status</th><th>Option</th></tr>
		<c:forEach var="emp" items="${empsList}">
		<tr style="color:blue">
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.sal}</td>
			<td>${emp.deptno}</td>
			<td>${emp.status}</td>
			<td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.png" width="40px" height="40px"></a>
					<a href="emp_delete?no=${emp.empno}" onclick="return confirm('do u want to delete the employee')"><img src="images/delete.jpg" width="40px" height="40px"></a></td>
		</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center">Employee not Found</h1>
	</c:otherwise>
</c:choose>

		<h2 style="color:green;text-align:center">${resultMsg}</h2>

<center>
</br>
<a href="emp_add"><img src="images/add.jpg" width="50px" height="50px"> Register Employee</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="./"><img src="images/home.png" width="50px" height="50px">Home</a>
</center>