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
账号（手机号）：<input name="user_phone_num" type="text" value="${userInforVo.user_phone_num}"><br/>
姓名：<input name="user_real_name" type="text" value="${userInforVo.user_real_name}"><br/>
<c:if test="${userInforVo.user_gender == 1}">
    <td>性别：男</td>
</c:if>
<c:if test="${userInforVo.user_gender == 0}">
    <td>性别：女</td>
</c:if>
身份证号：<input name="user_id_number" type="text" value="${userInforVo.user_id_number}"><br/>
邮箱：<input name="user_email" type="text" value="${userInforVo.user_email}"><br/>
地址：<input name="user_address" type="text" value="${userInforVo.user_address}"><br/>
<a href="/userInfor/userInforToIndex?id=${userInforVo.id}">
    返回
</a>
</body>
</html>