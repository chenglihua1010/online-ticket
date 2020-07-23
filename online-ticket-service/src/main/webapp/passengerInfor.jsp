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
<c:forEach items="${passengerVoList}" var="passenger">
    <thead>
    <tr>
        <th>乘客姓名</th>
        <th>乘客身份证号</th>
        <th>旅客类型</th>
        <th>乘客地址</th>
    </tr>
    </thead>
    <tbody>
    <a>
    <tr>
        <td>${passenger.passenger_real_name}</td>
        <td>${passenger.passenger_id_num}</td>
        <c:if test="${passenger.passenger_type==0}">
            <td>成人</td>
        </c:if>
        <c:if test="${passenger.passenger_type==1}">
            <td>儿童</td>
        </c:if>
        <c:if test="${passenger.passenger_type==2}">
            <td>学生</td>
        </c:if>
        <td>${passenger.passenger_address}</td>
    </tr>
</c:forEach>
    </a>
</tbody>

<form method="post" action="/passenger/addPassenger">
    用户账号：<input name="user_phone_num" type="text" value="${userInforVo.user_phone_num}">
    乘客姓名：<input  type="text" name="passenger_real_name" value="${passenger_real_name}"><br/>
    乘客身份证号：<input  type="text" name="passenger_id_num" value="${passenger_id_num}"><br/>
    旅客类型：<select name="passenger_type">
    <option name="passenger_type" value="0">-成人-</option>
    <option name="passenger_type" value="1">-儿童-</option>
    <option name="passenger_type" value="2">-学生-</option>
</select>
    乘客地址：<input  type="text" name="passenger_address" value="${passenger_address}"><br/>
    <input name="id" type="hidden" value="${userInforVo.id}">
    <input type="submit" value="提交并返回">
</form>

</body>
</html>