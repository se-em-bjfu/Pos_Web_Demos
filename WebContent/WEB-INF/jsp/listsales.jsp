<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>已完成销售列表</title>
</head>
<body>
	<div id="main">
		<h1>已完成销售列表</h1>
		<a href="mainMenu.do">返回主菜单</a>
		<table border="1">
			<tr>
				<th>序号</th><th>时间</th><th>所购总价</th><th>付款金额</th><th>察看详情</th>
			</tr>
			<c:forEach var="sale" items="${sales }" varStatus="status" >
			<tr>
				<td>${status.index+1 }</td>
				<td><fmt:formatDate value="${sale.date }" pattern="yy-MM-dd hh:mm" /></td>
				<td><fmt:formatNumber value="${sale.total /100.0}" pattern="0.00" /></td>
				<td><fmt:formatNumber value="${sale.payment.amount /100.0}" pattern="0.00" /></td>
				<td><a href="saleInfo.do?id=${status.index }">详情</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>