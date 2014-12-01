<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>POS处理支付界面</title>
</head>
<body>
	<div id="main">
		<h1>处理支付</h1>
		<h2>购买商品总价:<fmt:formatNumber value="${total /100.0}" pattern="0.00" /></h2>
		<form action="makePayment.do" method="POST">
			<table>
				<tr>
					<td>支付金额</td>
					<td><input type="text" name="amount" /></td>
				</tr>
				<tr>
					<td>支付类型</td>
					<td><select name="type">
						<c:forEach var="type" items="${paymentTypes}">
							<option value="${type}">${type}</option>
						</c:forEach>
					</select></td>
				</tr> 
				<tr>
					<td colspan="2"><input type="submit" value="提交" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>