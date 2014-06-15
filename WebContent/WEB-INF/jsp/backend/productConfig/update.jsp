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
<title>Update Product Config</title>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.3.2.js"></script>
<script type="text/javascript">
function updateProductConfigBtn_Click(){
	$("#updateProductConfigForm").submit();
};
</script>
</head>
<body>
	<form action="<%= basePath %>productConfig/${productConfig.id}/update" id="updateProductConfigForm" enctype="multipart/form-data" method="post">
		<table>
            <tr>
                <td>
                    Config Name :
                </td>
                <td>
                    <input type="text" name="configName" value="${productConfig.configName }"  />
                </td>
            </tr>
            <tr>
                <td>
                    Intro
                </td>
                <td>
                    <input type="text" name="intro" value="${productConfig.intro }" />
                </td>
            </tr>          
            <tr>
                <td>
                    Config :
                </td>
                <td>
                    <input type="text" name="config" value="${productConfig.config }" >
                </td>
            </tr>
            <tr>
                <td>
                    StandardConfig :
                </td>
                <td>
                    <input type="text" name="standardConfig" value="${productConfig.standardConfig }" >
                </td>
            </tr>
        </table>
        <input type="hidden" name="categoryId" value="${productConfig.categoryId }" />
		<button type="button" id="updateProductConfigBtn" onclick="updateProductConfigBtn_Click()"  >Submit</button>
		<button type="reset" >Reset</button>
	</form>
	
</body>
</html>