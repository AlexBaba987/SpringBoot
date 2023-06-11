<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red;text-align:center"><u>Register Employee</u></h1>

<frm:form modelAttribute="emp">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Emplyee Number:</td>
			<td><frm:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
			<td>Emplyee Name:</td>
			<td><frm:input path="ename"/></td>
		</tr>
		<tr>
			<td>Emplyee Desg:</td>
			<td><frm:input path="job"/></td>
		</tr>
		<tr>
			<td>Emplyee Salary:</td>
			<td><frm:input path="sal"/></td>
		</tr>
		<tr>
			<td>Dept Number:</td>
			<td><frm:input path="deptno"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update Employee"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
	</table>
</frm:form>