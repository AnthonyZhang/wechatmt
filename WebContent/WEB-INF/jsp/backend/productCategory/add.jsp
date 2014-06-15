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
<title>Add Product Category</title>
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
<script type="text/javascript">
function addProductCategoryBtn_Click(){
	$("#addProductCategoryForm").submit();
};
</script>
</head>
<body>
	<form action="<%= basePath %>productCategory/add" id="addProductCategoryForm" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>
					Name :
				</td>
				<td>
					<input type="text" name="name" value=""  placeholder="Name"/>
				</td>
			</tr>
			<tr>
				<td>
					Product Category Image :
				</td>
				<td>
					<input type="file" name="newsImg" />
				</td>
			</tr>	       
			<tr>
				<td>
					Description :
				</td>
				<td>
					<input type="text" name="description" value="" placeholder="Description">
				</td>
			</tr>
			<tr>
				<td>
					Introduction :
				</td>
				<td>
					<input type="text" name="intro" value="" placeholder="Introduction">
				</td>
			</tr>
		</table>
		<c:if test="${parentCategoryId == '' }">
		      <input type="hidden" name="parentCategoryId" value="0" />
		</c:if>
		<c:if test="${parentCategoryId != '' }">
		      <input type="hidden" name="parentCategoryId" value="${parentCategoryId }" />
		</c:if>
	    
		<button type="button" id="addProductCategoryBtn" onclick="addProductCategoryBtn_Click()"  >Submit</button>
		<button type="reset" >Reset</button>
	</form>
	
</body>
</html>