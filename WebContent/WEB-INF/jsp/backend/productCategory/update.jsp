<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Category</title>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.3.2.js"></script>
<script type="text/javascript">
function updateProductCategoryBtn_Click(){
	$("#updateProductCategoryForm").submit();
};
</script>
</head>
<body>
	<form action="<%= basePath %>productCategory/${category.id}/update" id="updateProductCategoryForm" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>
					Name :
				</td>
				<td>
					<input type="text" name="name" value="${category.name }"  placeholder="Name"/>
				</td>
			</tr>
			<tr>
				<td>
                    News Image :
                </td>
                <td>
                    <!-- <input type="file" name="newsImg" /> -->
                    <img alt="Image" src="<%=basePath %>${category.menuImg }">
                    <input type="hidden" value="${category.menuImg }" name="menuImg">
                    重新上传 ： <input type="file" name="newsImg" />
                </td>
			</tr>	       
			<tr>
				<td>
					Description :
				</td>
				<td>
					<input type="text" name="description" value="${category.description }" placeholder="Description">
				</td>
			</tr>
			<tr>
				<td>
					Introduction :
				</td>
				<td>
					<input type="text" name="intro" value="${category.intro }" placeholder="Introduction">
				</td>
			</tr>
		</table>
	    <input type="hidden" name="categoryLevel" value="${category.categoryLevel }"/>
	    <input type="hidden" name="parentCategoryId" value="${category.parentCategoryId }" />
		<button type="button" id="updateProductCategoryBtn" onclick="updateProductCategoryBtn_Click()"  >Submit</button>
		<button type="reset" >Reset</button>
	</form>
	
</body>
</html>