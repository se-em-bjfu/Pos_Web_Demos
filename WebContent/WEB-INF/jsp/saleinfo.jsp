<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>销售记录详细信息</title>
</head>
<body>
	<div id="main">
		<h1>销售记录详细信息</h1>
		<a href="listSales.do">返回销售记录列表</a>
		<p>已购商品总价:<fmt:formatNumber value="${sale.total /100.0}" pattern="0.00" /></p>
		<p>支付金额:<fmt:formatNumber value="${sale.payment.amount /100.0}" pattern="0.00" /></p>
		<div id="itemList" >
			<table border="1">
				<tr>
					<th>商品名称</th><th>单价</th><th>商品数量</th><th>合计</th>
				</tr>
				<c:forEach var="item" items="${sale.lineItems }" >
				<tr>
					<td>${item.productDescription.name }</td>
					<td><fmt:formatNumber value="${item.productDescription.price /100.0}" pattern="0.00" /></td>
					<td>${item.quantity }</td>
					<td><fmt:formatNumber value="${item.subTotal /100.0}" pattern="0.00" /></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>