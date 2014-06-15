<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Config</title>
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
<script type="text/javascript">
function addProductConfigBtn_Click(){
	$("#addProductConfigForm").submit();
};
</script>
</head>
<body>
	<form action="<%= basePath %>productConfig/add" id="addProductConfigForm" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>
					Config Name :
				</td>
				<td>
					<input type="text" name="configName" value=""  placeholder="Name"/>
				</td>
			</tr>
			<tr>
				<td>
					Intro
				</td>
				<td>
					<input type="text" name="intro" value="" palceholder="Intro" />
				</td>
			</tr>	       
			<tr>
				<td>
					Config :
				</td>
				<td>
					<input type="text" name="config" value="" placeholder="config">
				</td>
			</tr>
			<tr>
				<td>
					StandardConfig :
				</td>
				<td>
					<input type="text" name="standardConfig" value="" placeholder="StandardConfig">
				</td>
			</tr>
		</table>
		<c:if test="${categoryId == '' }">
		      <input type="hidden" name="categoryId" value="0" />
		</c:if>
		<c:if test="${categoryId != '' }">
		      <input type="hidden" name="categoryId" value="${categoryId }" />
		</c:if>
	    
		<button type="button" id="addProductConfigBtn" onclick="addProductConfigBtn_Click()"  >Submit</button>
		<button type="reset" >Reset</button>
	</form>
	
</body>
</html>