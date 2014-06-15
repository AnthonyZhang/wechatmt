<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List News</title>
</head>
<body>
	<a href="<c:url value='/news/toAdd'/>">新增</a><br/>
    <table border="1">
        <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Intro</th>
                        <th>Create Time</th>
                        <th>menuImg</th>
                        <th>操作</th>
        </tr>
        <c:forEach items="${page.items}" var="t" varStatus="status">
        <tr>
                        <td>${ t.id }</td>
                        <td>${ t.title }</td>
                        <td>${ t.intro }</td>
                        <td>${ t.createDate }</td>
                        
                        <td><img src="../${ t.menuImg }" /></td>
                        <td><a href="<c:url value='/news/${t.id}/delete'/>">删除</a>|<a href="<c:url value='/news/${t.id}/toUpdate'/>">修改</a></td>
        </tr>
        </c:forEach>
    </table>
    <common:pageV2 url="/news/list" optimize="true"/>
</body>
</html>