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
        ${trainInforVoList.get(0).train_num}经停信息
    </title>
</header>

<thead>
<tr>
    <th>序号</th>
    <th>站名</th>
    <th>出发时间</th>
    <th>到达时间</th>
    <th>运行时间</th>
</tr>
</thead>

    <c:forEach items="${trainParkingStationVoList}" var="trainInforVo">
    <tr>
        <td>${trainInforVo.station_no}</td>
        <td>${trainInforVo.station_name}</td>
        <td>${trainInforVo.train_start_time}</td>
        <td>${trainInforVo.train_end_time}</td>
        <td>${trainInforVo.train_running_time}</td>
    </tr>
    </c:forEach>

</table>


</body>
</html>