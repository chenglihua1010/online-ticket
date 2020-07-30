<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"><!DOCTYPE html>
<html>
<body>
<form type="post" action="/orderList/selectPartOrderByUser_phone_num">
账号（手机号）：<input name="user_phone_num" type="text" value="${userInforVo.user_phone_num}"><br/>
订单类型：<select name="order_status">
    <option value="0">-全部-</option>
    <option value="1">-未支付-</option>
    <option value="2">-已支付，未出行-</option>
    <option value="3">-已支付，已出行-</option>
    <option value="4">-已改签-</option>
    <option value="5">-已退票-</option>
</select>
<input type="submit" value="查询">
</form>
<%--<a href="/orderList/selectPartOrderByUser_phone_num?user_phone_num=${user_phone_num}&order_status=">--%>
    <%--返回--%>
<%--</a>--%>
</body>
</html>