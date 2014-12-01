<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>POS处理销售界面</title>
</head>
<body>
	<div id="main">
		<h1>处理销售</h1>
		<form action="enterItem.do" method="POST">
			<table>
				<tr>
					<td>商品ID</td>
					<td><input type="text" name="itemID" /></td>
				</tr>
				<tr>
					<td>数量</td>
					<td><input type="text" name="quantity" value="1" /></td>
				</tr> 
				<tr>
					<td colspan="2"><input type="submit" value="提交" /></td>
				</tr>
			</table>
		</form>
		<a href="endSale.do">结束商品输入</a>
		<h2>已购商品总价:<fmt:formatNumber value="${total /100.0}" pattern="0.00" /></h2>
		<div id="itemList" >
			<table border="1">
				<tr>
					<th>商品名称</th><th>单价</th><th>商品数量</th><th>合计</th>
				</tr>
				<c:forEach var="item" items="${saleItems }" >
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