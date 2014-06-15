<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Product Config</title>
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
<script type="text/javascript">
function testJson_OnLoad(){
	 var mydata = "entity:{name:name,id:value,status:status}";  
     alert(mydata);  
    $.ajax({
        type : "post",
        url :  "../productConfig/3/testJson",
        data : mydata,
        contentType : "application/json",
        processData : true,
        dataType : "json",
        success : function(data) {
            console.log(data);
        },
        error : function() {
            alert("Operation Failed");
        }
    });
};
</script>
</head>
<body>
<p onclick="testJson_OnLoad()">testJson</p>
	<%-- <a href="<c:url value='/news/toAdd'/>">新增</a><br/> --%>
	<a href="<c:url value='/productConfig/toAdd?categoryId=${t.id }'/>">添加产品</a><br/>
    <table border="1">
        <tr>
                        <th>ID</th>
                        <th>Config Name</th>
                        <th>StandardConfig</th>
                        <th>Config</th>
                        <th>Intro</th>
                        <th>Create Time</th>
                        <th>Update Time</th>
                        <th>操作</th>
        </tr>
        <c:forEach items="${page.items}" var="t" varStatus="status">
        <tr>
                        <td>${ t.id }</td>
                        <td>${ t.configName }</td>
                        <td>${ t.standardConfig }</td>
                        <td>${ t.config }</td>
                        <td>${ t.intro }</td>
                        <td>${ t.createDate }</td>
                        <td>${ t.updateDate }</td>
                        <td>
                                <a href="<c:url value='/productConfig/${t.id}/delete'/>">删除</a>
                                |<a href="<c:url value='/productConfig/${t.id}/toUpdate'/>">修改</a>
                        
                        </td>
        </tr>
        </c:forEach>
    </table>
    <common:pageV2 url="/productCategory/list" optimize="true"/>
</body>
</html>