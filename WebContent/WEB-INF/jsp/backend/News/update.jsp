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
<title>Update News</title>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/backend/news/news.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	var ue;
	function initEditor_onLoad(){
			// 实例化编辑器
	        ue = UE.getEditor('container');
	        ue.ready(function() {
	        	var content = $("#newsContentDiv").html();
	        	console.log(content);
	            //设置编辑器的内容
	            ue.setContent(content);
	            //获取html内容，返回: <p>hello</p>
	            /* var html = ue.getContent();
	            //获取纯文本内容，返回: hello
	            var txt = ue.getContentTxt();
	            console.log(html);
	            console.log(txt); */
	        });
	}
	
	function updateNewsBtn_Click(){
		var content = ue.getContent();
		$("#newsContent").attr("value", content);
		$("#updateNewsForm").submit();
	};
</script>
</head>
<body onload="initEditor_onLoad()">
	<form action="<%= basePath %>news/${news.id }/update" id="updateNewsForm" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>
					Title :
				</td>
				<td>
					<input type="text" name="title" value="${news.title }"  placeholder="Title"/>
				</td>
			</tr>
			<tr>
				<td>
					News Image :
				</td>
				<td>
					<!-- <input type="file" name="newsImg" /> -->
					<img alt="Image" src="<%=basePath %>${news.menuImg }">
					<input type="hidden" value="${news.menuImg }" name="menuImg">
				    重新上传 ： <input type="file" name="newsImg" />
				</td>
			</tr>	       
			<tr>
				<td>
					Introduce :
				</td>
				<td>
					<input type="text" name="intro" value="${news.intro }" placeholder="Intro">
				</td>
			</tr>	      	
			</table>
			<div  id="newsContentDiv" style="display: none" >
				${news.content }
			</div>
			<input type="hidden" name="content" value="" id="newsContent">
			Content :
			<div id="container"></div>
			<input type="hidden" value="${news.createDate }" name="createDate"/>
			<button type="button" id="updateNewsBtn" onclick="updateNewsBtn_Click()" >Update</button>
			<button type="reset" >Reset</button>
	</form>
</body>
</html>