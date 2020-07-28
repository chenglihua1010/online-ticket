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
<div class="modal fade" id="myModalbook" role="dialog">
<div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">

            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <h4 class="modal-title">
                行程确认单</h4>
            <form class="w3layouts-train-form" action="/orderList/addOrder" method="post">
                <%--传对象--%>
                <%--<input name="trainInforVo" value="${trainInforList[0]}" type="hidden">--%>
                <%--列车信息--%>
                <input name="train_no" value="${trainInforList[1].train_no}" type="hidden">
                <input name="train_num" value="${trainInforList[1].train_num}" type="hidden">
                <input name="start_station_name" value="${trainInforList[1].train_start_station}" type="hidden">
                <input name="end_station_name" value="${trainInforList[1].train_end_station}" type="hidden">
                <input name="train_start_time" value="${trainInforList[1].train_start_time}" type="hidden">
                <%--用户信息--账号--%>
                <input name="user_phone_num" value="${passengerVoList[0].user_phone_num}" type="hidden">

                <div class="table-responsive">
                    <table class="table table-bordered agileinfo">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>票种</th>
                            <th>席别</th>
                            <th>姓名</th>
                            <th>证件号码</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="t-one">1</td>
                            <td class="wthree">
                                <select name="passenger_type">
                                    <option name="passenger_type" value="0">成人票</option>
                                    <option name="passenger_type" value="1">学生票</option>
                                    <option name="passenger_type" value="2">儿童票</option>
                                </select>
                            </td>
                            <td class="wthree">
                                <select name="seat_type">
                                    <option type="text" value="0">-请选择座位类型-</option>
                                    <option name="seat_type" value="${seatVoList[0].seat_type},${seatVoList[0].seat_count}">一等座（价格：${seatVoList[0].seat_price}元）</option>
                                    <option name="seat_type" value="${seatVoList[1].seat_type},${seatVoList[1].seat_count}">一等座（价格：${seatVoList[1].seat_price}元）</option>
                                    <option name="seat_type" value="${seatVoList[2].seat_type},${seatVoList[2].seat_count}">一等座（价格：${seatVoList[2].seat_price}元）</option>
                                    <%--<option name="seat_type" value="${seatVoList[1].seat_type}">二等座（价格：100元）</option>--%>
                                    <%--<option name="seat_type" value="${seatVoList[2].seat_type}">商务座（价格：300元）</option>--%>
                                </select>
                            </td>
                            <%--再选择姓名后，自动获取身份信息--%>
                            <td class="wthree">
                                <select name="passenger_real_name">
                                    <c:forEach items="${passengerVoList}" var="passenger" >
                                        <option name="passenger_real_name" value="${passenger.passenger_real_name}">${passenger.passenger_real_name} </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="wthree">
                                <select name="passenger_id_num">
                                    <c:forEach items="${passengerVoList}" var="passenger" >
                                        <option name="passenger_id_num" value="${passenger.passenger_id_num}">${passenger.passenger_id_num}</option>
                                    </c:forEach>

                                </select>
                            </td>
                        </tr>

                        <%--<tr>--%>
                        <%--<td class="t-one">2</td>--%>
                        <%--<td class="wthree">--%>
                        <%--<select name="票种">--%>
                        <%--<option name="" value="">成人票</option>--%>
                        <%--</select>--%>
                        <%--</td>--%>
                        <%--<td class="wthree">--%>
                        <%--<select name="seat_type">--%>
                        <%--<option name="seat_type" value="4">一等座（价格：200元）</option>--%>
                        <%--<option name="seat_type" value="5">二等座（价格：100元）</option>--%>
                        <%--<option name="seat_type" value="6">商务座（价格：300元）</option>--%>
                        <%--</select>--%>
                        <%--</td>--%>
                        <%--&lt;%&ndash;再选择姓名后，自动获取身份信息&ndash;%&gt;--%>
                        <%--<td class="wthree">--%>
                        <%--<select name="passenger_real_name">--%>
                        <%--<c:forEach items="${passengerVoList}" var="passenger" >--%>
                        <%--<option value="${passenger_real_name}">${passenger.passenger_real_name} </option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                        <%--</td>--%>
                        <%--<td class="wthree">--%>
                        <%--<select name="passenger_id_num">--%>
                        <%--<c:forEach items="${passengerVoList}" var="passenger" >--%>
                        <%--<option name="passenger_id_num" value="passenger_id_num">${passenger.passenger_id_num}</option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                        <%--</td>--%>
                        <%--</tr>--%>


                        <tr>
                            <td class="t-one">3</td>
                            <td class="wthree"><input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"><input type="text" placeholder="" /></td>


                        </tr>
                        <tr>
                            <td class="t-one">4</td>
                            <td class="wthree"><input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"><input type="text" placeholder="" /></td>


                        </tr>
                        <tr>
                            <td class="t-one">5</td>
                            <td class="wthree"><input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"><input type="text" placeholder="" /></td>

                        </tr>
                        <tr>
                            <td class="t-one">6</td>
                            <td class="wthree"><input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"><input type="text" placeholder="" /></td>


                        </tr>
                        <tr>
                            <td class="t-one">7</td>
                            <td class="wthree"><input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"> <input type="text" placeholder="" /></td>
                            <td class="wthree"><input type="text" placeholder="" /></td>


                        </tr>
                        </tbody>
                    </table>
                </div>
                <input type="submit" class="submit" value="提交订单"/>
            </form>
        </div>
    </div>
</div>
    </div>
</body>
</html>