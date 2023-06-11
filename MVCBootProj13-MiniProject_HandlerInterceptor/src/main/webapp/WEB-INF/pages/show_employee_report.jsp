<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"/>

<div class="container">
<c:choose>
	<c:when test="${!empty empsData.getContent()}">
	<h1 style="color:red;text-align:center"> <u>Employees Report</u></h1>
	</br>
	<!-- <table border="1" align="center" class="table table-hover"> -->
	<table border="1" class="table table-hover">
		<thead class="thead-light"><tr><th scope="col">EmpNo</th><th scope="col">Ename</th><th scope="col">Job</th><th scope="col">Salary</th><th scope="col">DeptNo</th><th scope="col">Status</th><th scope="col">Option</th></tr></thead>
		<c:forEach var="emp" items="${empsData.getContent()}">
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
	<center>
	
	
	<c:if test="${!empsData.isFirst()}">
		<a href="emp_report?page=0">First</a> &nbsp;
	</c:if>
	
	<c:if test="${empsData.hasNext()}">
		<a href="emp_report?page=${empsData.getPageable().getPageNumber()+1}">Next</a>&nbsp;
	</c:if>
	
	<c:forEach var="i" begin="0" end="${empsData.getTotalPages()-1}" step="1">
		<a href="emp_report?page=${i}">${i+1}</a>&nbsp;
	</c:forEach>
	
	<c:if test="${empsData.hasPrevious()}">
		<a href="emp_report?page=${empsData.getPageable().getPageNumber()-1}">Previous</a>&nbsp;
	</c:if>
	
	<c:if test="${!empsData.isLast()}">
		<a href="emp_report?page=${empsData.getTotalPages()-1}">Last</a>
	</c:if>
	
		</center>
		<h3>Current Page No:${empsData.getPageable().getPageNumber()+1}/${empsData.getTotalPages()}</h3>
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
</div>