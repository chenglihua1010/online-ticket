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
<table>
    <header>
        <title>
            ${orderListVo[0].user_phone_num}订单信息
        </title>
    </header>
    <thead>
    <tr>
        <th>乘客姓名</th>
        <th>车次</th>
        <th>起点站</th>
        <th>终点站</th>
        <th>搭乘时间</th>
        <th>订单价格</th>
        <th>订单时间</th>
    </tr>
    </thead>

    <c:forEach items="${orderListVo}" var="orderListVo">
        <tr>
            <td>${orderListVo.passenger_real_name}</td>
            <td>${orderListVo.train_num}</td>
            <td>${orderListVo.start_station_name}</td>
            <td>${orderListVo.end_station_name}</td>
            <td>${orderListVo.train_start_date}</td>
            <td>${orderListVo.order_money}</td>
            <td>${orderListVo.order_create_time}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>