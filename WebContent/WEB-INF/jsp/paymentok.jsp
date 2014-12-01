<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>POS处理支付完成界面</title>
</head>
<body>
	<div id="main">
		<h1>处理支付完成</h1>
		<p>购买商品总价:<fmt:formatNumber value="${total /100.0}" pattern="0.00" /></p>
		<p>付款金额总价:<fmt:formatNumber value="${amount /100.0}" pattern="0.00" /></p>
		<h2>找零:<fmt:formatNumber value="${change /100.0}" pattern="0.00" /></h2>
		<a href="mainMenu.do" >完成</a>
	</div>
</body>
</html>