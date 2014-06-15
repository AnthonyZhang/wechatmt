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
<title>Add News</title>
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="../js/backend/news/news.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
function addNewsBtn_Click(){
	var content = ue.getContent();
	$("#newsContent").attr("value",content);
	$("#addNewsForm").submit();
};
</script>
</head>
<body>
	<form action="<%= basePath %>news/add" id="addNewsForm" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>
					Title :
				</td>
				<td>
					<input type="text" name="title" value=""  placeholder="Title"/>
				</td>
			</tr>
			<tr>
				<td>
					News Image :
				</td>
				<td>
					<input type="file" name="newsImg" />
				</td>
			</tr>	       
			<tr>
				<td>
					Introduce :
				</td>
				<td>
					<input type="text" name="intro" value="" placeholder="Intro">
				</td>
			</tr>	      	
			</table>
					Content :<br/>
			
					<!-- <textarea rows="8" cols="45" name="content" placeholder="Content"></textarea> -->
					<script id="container"  type="text/plain">
						 
  					</script>
				  
				    <!-- 实例化编辑器 -->
				    <script type="text/javascript">
				        var ue = UE.getEditor('container');
				    </script>
				    <input type="hidden" name="content" id="newsContent" value=""/>
					<button type="button" id="addNewsBtn" onclick="addNewsBtn_Click()"  >Submit</button>
					<button type="reset" >Reset</button>
	</form>
	
</body>
</html>