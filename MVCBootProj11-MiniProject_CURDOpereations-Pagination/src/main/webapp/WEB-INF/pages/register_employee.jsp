<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<link rel="stylesheet" href="css/style.css">

<h1 style="color:red;text-align:center"><u>Register Employee</u></h1>

<frm:form modelAttribute="emp">
		<%-- <p style="color:red;text-align:center">
			<frm:errors path="*"/>
		</p> --%>
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Emplyee name:</td>
			<td><frm:input path="ename"/><frm:errors path="ename" /></td>
		</tr>
		<tr>
			<td>Emplyee Desg:</td>
			<td><frm:input path="job"/><frm:errors path="job" /></td>
		</tr>
		<tr>
			<td>Emplyee Salary:</td>
			<td><frm:input path="sal"/><frm:errors path="sal"/></td>
		</tr>
		<tr>
			<td>Dept no:</td>
			<td><frm:select path="deptno">
						<frm:options items="${deptNoInfo}"/>
					</frm:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
	</table>
</frm:form>