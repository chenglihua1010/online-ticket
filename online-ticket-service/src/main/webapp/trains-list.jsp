<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--中文转码--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%--引入c标签——>foreach循环--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"><!DOCTYPE html>
<!-- html -->
<html>
<!-- head -->
<head>
<title>列车信息</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!-- bootstrap-CSS -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /><!-- Fontawesome-CSS -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<!-- metatags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- /metatags --> 
<!-- online fonts -->
<link href="http://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext,vietnamese" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Oxygen:300,400,700&amp;subset=latin-ext" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- /online fonts -->

</head>
<!-- /head -->
<!-- body -->
<body>
<!--header-->
<header>
	<div class="container">
		<!--logo-->
			<div class="logo">
				<h1><a href="index.html">Online Recharge</a></h1>
			</div>
		<!--//logo-->
		  <div class="w3layouts-login">
				<a data-toggle="modal" data-target="#myModal" href="#"><i class="glyphicon glyphicon-user"> </i>Login/Register</a>
			</div>    
				<div class="clearfix"></div>
    <!--Login modal-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
            aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            Online Recharge</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-8 extra-w3layouts" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                                <!-- Nav tabs -->
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#Login" data-toggle="tab">Login</a></li>
                                    <li><a href="#Registration" data-toggle="tab">Register</a></li>
                                </ul>
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="Login">
                                        <form  class="form-horizontal" action="#" method="get">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-2 control-label">
                                                Email</label>
                                            <div class="col-sm-10">
                                                <input type="email" class="form-control" id="email1" placeholder="Email" required="required" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="col-sm-2 control-label">
                                                Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password" required="required" />
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-2">
                                            </div>
                                            <div class="col-sm-10">
                                                <button type="submit" class="submit btn btn-primary btn-sm">
                                                    Submit</button>
                                                <a href="javascript:;" class="agileits-forgot">Forgot your password?</a>
                                            </div>
                                        </div>
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="Registration">
                                        <form  class="form-horizontal" action="#" method="get">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-2 control-label">
                                                Name</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                                        <select class="form-control">
                                                            <option>Mr.</option>
                                                            <option>Ms.</option>
                                                            <option>Mrs.</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-9 col-sm-9 col-xs-9">
                                                        <input type="text" class="form-control" placeholder="Name" required="required" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="col-sm-2 control-label">
                                                Email</label>
                                            <div class="col-sm-10">
                                                <input type="email" class="form-control" id="email" placeholder="Email" required="required" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="mobile" class="col-sm-2 control-label">
                                                Mobile</label>
                                            <div class="col-sm-10">
                                                <input type="tel" class="form-control" id="mobile" placeholder="Mobile" required="required" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="password" class="col-sm-2 control-label">
                                                Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" class="form-control" id="password" placeholder="Password" required="required" />
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-2">
                                            </div>
                                            <div class="col-sm-10">
                                                <button type="submit" class="submit btn btn-primary btn-sm">
                                                    Save & Continue</button>
                                                <button type="reset" class="submit btn btn-default btn-sm">
                                                    Cancel</button>
                                            </div>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                                <div id="OR"  >
                                    OR</div>
                            </div>
                            <div class="col-md-4 extra-agileits">
                                <div class="row text-center sign-with">
                                    <div class="col-md-12">
                                        <h3 class="other-nw">
                                            Sign in with</h3>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="btn-group btn-group-justified">
                                            <a href="#" class="btn btn-primary">Facebook</a> <a href="#" class="btn btn-danger">
                                                Google +</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!--//Login modal-->
    </div>
</header>
<!-- //header -->
	
<!-- innerbanner -->	
	<div class="agileits-inner-banner">
		
	</div>
<!-- //innerbanner -->

<!-- breadcrumbs -->
	<div class="w3layouts-breadcrumbs text-center">
		<div class="container">
			<span class="agile-breadcrumbs"><a href="index.html"><i class="fa fa-home home_1"></i></a> / <span>列车信息</span></span>
		</div>
	</div>
	<!-- //breadcrumbs -->
	<!-- Trains-list -->
	<div class="agile-trains-list w3layouts-content">
     <div class="container
	<!--bus-single --> 
            <div class="w3agile single-bus">
			         <h3 class="w3-head">列车信息</h3>
			 <!-- train-routes -->
					<div class="bus-tp">
						<div class="bus-tp-inner">
							<%--<h3>${trainInforList.get(0).train_start_station}至${trainInforList.get(0).train_end_station}</h3>--%>
							<h3>${trainInforList[0].train_start_station}至${trainInforList[0].train_end_station}</h3>
							<div class="clearfix"></div>
						</div>
					</div>
				<!-- /train-routes -->
				<!-- bus-midd -->
<div class="w3agile bus-midd">
  	     <div class="table-responsive">
		   <table class="table table-bordered agileinfo"> 
	           <thead>
 			       <tr> 
					   <th>Train no.</th>  
					   <th>车次</th>
					   <th>出发时间</th>
					   <th>到达时间</th>
					   <th>历时</th>
					   <th>座位信息</th>
					   <%--座位信息--%>
					   <th>备注</th>
				   </tr> 
			  </thead>
		   <tbody>
		   <%--循环展示列车信息--%>
		   <%--问题：加上座位信息--%>
		   <%--<form type="post" action="orderList/preorder">--%>
				<c:forEach items="${trainInforList}" var="trainInfor">
		     <tr>
			    <td class="t-one">${trainInfor.train_no}</td>
			    <td class="wthree"><i class="fa fa-train" aria-hidden="true"></i>
					<%--经停信息查询--%>
					<a href="/trainParkingStation/selectStationByTrain_no?train_no=${trainInfor.train_no}">
							${trainInfor.train_num}
					</a>
				</td>
 				<td class="wthree"><i class="fa fa-clock-o" name="train_start_time_String" value="${trainInfor.train_start_time_String}"></i>${trainInfor.train_start_time_String}</td>
 				<td class="wthree"><i class="fa fa-clock-o" name="train_end_time_String" value="${trainInfor.train_end_time_String}"></i>${trainInfor.train_end_time_String}</td>
 				<td class="wthree"><i class="fa fa-clock-o" name="train_running_time" value="${trainInfor.train_running_time}"></i>${trainInfor.train_running_time}</td>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>${trainInfor.train_end_time_String}</td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>${trainInfor.train_running_time}</td>--%>
				 <%--逻辑为完善，应显示最少的座位数--%>
				<td class="wthree"><i class="fa fa-clock-o"></i>一等座-${seatVoList[0].seat_count}二等座-${seatVoList[1].seat_count}商务座-${seatVoList[2].seat_count}</td>
				<%--<td class="seat"> <span title="Sunday"></span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				 <%--${TrainInfor.train_price}--%>
				 <td class="price us">
					 <%--如何将数据传过去 在controller写一层--%>
						<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two"> 预订 </a>
					 <%--<input name="trainInfor" value="${trainInfor}" type="hidden">--%>
					 <%--<input type="submit" value="预订">--%>
				</td>

			 </tr>
				</c:forEach>
		   <%--</form>--%>

			 <%--<tr>--%>
			    <%--<td class="t-one">45212</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name </td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>06:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>12:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="not available"></span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			 <%--<tr>--%>
			    <%--<td class="t-one">358314</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>

				<%--<td class="wthree"><i class="fa fa-clock-o"></i>22:10 </td>--%>
				<%--<td class="seat"> <span title="not available"></span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="not available"></span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">58974</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>07:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">86547</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>05:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>14:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="not available"></span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>
			  <%--</tr>--%>
               <%--<tr>--%>
			    <%--<td class="t-one">15798</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name </td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>08:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>13:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			 <%--<tr>--%>
			    <%--<td class="t-one">45212</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name </td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>06:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>12:10 </td>--%>
				<%--<td class="seat"> <span title="not available"></span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="not available"></span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			 <%--<tr>--%>
			    <%--<td class="t-one">358314</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>

				<%--<td class="wthree"><i class="fa fa-clock-o"></i>22:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="not available"></span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">58974</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>07:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">86547</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>05:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>14:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="not available"></span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>
			  <%--</tr>--%>
               <%--<tr>--%>
			    <%--<td class="t-one">15798</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name </td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>08:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>13:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			 <%--<tr>--%>
			    <%--<td class="t-one">45212</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name </td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>06:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>12:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="not available"></span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="not available"></span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			 <%--<tr>--%>
			    <%--<td class="t-one">358314</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>

				<%--<td class="wthree"><i class="fa fa-clock-o"></i>22:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="not available"></span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">58974</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>07:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>15:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="Tuesday">T</span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>

			 <%--</tr>--%>
			  <%--<tr>--%>
			    <%--<td class="t-one">86547</td>--%>
			    <%--<td class="wthree"><i class="fa fa-train" aria-hidden="true"></i> Train name</td>--%>
 				<%--<td class="wthree"><i class="fa fa-clock-o"></i>05:10 </td>--%>
				<%--<td class="wthree"><i class="fa fa-clock-o"></i>14:10 </td>--%>
				<%--<td class="seat"> <span title="Sunday">S</span> <span title="Monday">M</span> <span title="not available"></span> <span title="Wednesday">W</span> <span title="Thursday">T</span> <span title="Friday">F</span> <span title="Saturday">S</span></td>--%>
				<%--<td class="price us">Price here--%>
						<%--<a href="#" data-toggle="modal" data-target="#myModalbook" class="seat-button two">Book Now</a>--%>
				<%--</td>--%>
			  <%--</tr>--%>
			 </tbody> 
		</table>
		</div>
	</div>
</div>
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
							<input name="train_start_time_String" value="${trainInforList[1].train_start_time_String}" type="hidden">
							<%--<input name="seat_price" value="${}" type="hidden">--%>
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
							<option name="seat_type" value="${seatVoList[0].seat_type},${seatVoList[0].seat_price},${seatVoList[0].seat_count},${seatVoList[0].id}">一等座（价格：${seatVoList[0].seat_price}元）</option>
							<option name="seat_type" value="${seatVoList[1].seat_type},${seatVoList[1].seat_price},${seatVoList[1].seat_count},${seatVoList[1].id}">一等座（价格：${seatVoList[1].seat_price}元）</option>
							<option name="seat_type" value="${seatVoList[2].seat_type},${seatVoList[2].seat_price},${seatVoList[2].seat_count},${seatVoList[2].id}">一等座（价格：${seatVoList[2].seat_price}元）</option>
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
</div>
</div>
<!-- //Trains-list -->

<!-- subscribe -->
	<div class="w3-subscribe agileits-w3layouts"> 
		<div class="container">
			<div class="col-md-6 social-icons w3-agile-icons">
				<h4>Join Us</h4>  
				<ul>
					<li><a href="#" class="fa fa-facebook sicon facebook"> </a></li>
					<li><a href="#" class="fa fa-twitter sicon twitter"> </a></li>
					<li><a href="#" class="fa fa-google-plus sicon googleplus"> </a></li>
					<li><a href="#" class="fa fa-dribbble sicon dribbble"> </a></li>
					<li><a href="#" class="fa fa-rss sicon rss"> </a></li> 
				</ul> 
			</div> 
			<div class="col-md-6 w3-agile-subscribe-right">
				<h3 class="w3ls-title">Subscribe to Our <br><span>Newsletter</span></h3>  
				<form action="#" method="post"> 
					<input type="email" name="email" placeholder="Enter your Email..." required="">
					<input type="submit" value="Subscribe">
					<div class="clearfix"> </div> 
				</form>  
			</div>
			<div class="clearfix"> </div> 
		</div>
	</div>
	<!-- //subscribe --> 

<!--footer-->
<footer>
	<div class="container-fluid">
		<div class="w3-agile-footer-top-at">
			<div class="col-md-2 agileits-amet-sed">
				<h4>Company</h4>
				<ul class="w3ls-nav-bottom">
					<li><a href="about.jsp">About Us</a></li>
					<li><a href="support.jsp">Support</a></li>
					<li><a href="sitemap.jsp">Sitemap</a></li>
					<li><a href="terms.jsp">Terms & Conditions</a></li>
					<li><a href="faq.jsp">Faq</a></li>
					<li><a href="index.html#mobileappagileits">Mobile</a></li>	
					<li><a href="feedback.jsp">Feedback</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="shortcodes.html">Shortcodes</a></li>
					<%--<li><a href="shortcodes.jsp">Shortcodes</a></li>--%>
					<li><a href="icons.jsp">Icons Page</a></li>
					
				</ul>	
			</div>
			<div class="col-md-3 agileits-amet-sed ">
				<h4>Mobile Recharges</h4>
					<ul class="w3ls-nav-bottom">
						<li><a href="index.html#parentVerticalTab1">Airtel</a></li>
						<li><a href="index.html#parentVerticalTab1">Aircel</a></li>
						<li><a href="index.html#parentVerticalTab1">Vodafone</a></li>
						<li><a href="index.html#parentVerticalTab1">BSNL</a></li>
						<li><a href="index.html#parentVerticalTab1">Tata Docomo</a></li>
						<li><a href="index.html#parentVerticalTab1">Reliance GSM</a></li>	
						<li><a href="index.html#parentVerticalTab1">Reliance CDMA</a></li>	
						<li><a href="index.html#parentVerticalTab1">Telenor</a></li>	
						<li><a href="index.html#parentVerticalTab1">MTS</a></li>	
						<li><a href="index.html#parentVerticalTab1">Jio</a></li>	
					</ul>	
			</div>
			<div class="col-md-3 agileits-amet-sed ">
				<h4>DATACARD RECHARGES</h4>
				   <ul class="w3ls-nav-bottom">
						<li><a href="index.html#parentVerticalTab3">Tata Photon</a></li>
						<li><a href="index.html#parentVerticalTab3">MTS MBlaze</a></li>
						<li><a href="index.html#parentVerticalTab3">MTS MBrowse</a></li>
						<li><a href="index.html#parentVerticalTab3">Airtel</a></li>
						<li><a href="index.html#parentVerticalTab3">Aircel</a></li>
						<li><a href="index.html#parentVerticalTab3">BSNL</a></li>	
						<li><a href="index.html#parentVerticalTab3">MTNL Delhi</a></li>	
						<li><a href="index.html#parentVerticalTab3">Vodafone</a></li>	
						<li><a href="index.html#parentVerticalTab3">Idea</a></li>	
						<li><a href="index.html#parentVerticalTab3">MTNL Mumbai</a></li>
						<li><a href="index.html#parentVerticalTab3">Tata Photon Whiz</a></li>	
					</ul>	
			</div>
			<div class="col-md-2 agileits-amet-sed">
				<h4>DTH Recharges</h4>
				<ul class="w3ls-nav-bottom">
						<li><a href="index.html#parentVerticalTab2"> Airtel Digital TV Recharges</a></li>
						<li><a href="index.html#parentVerticalTab2">Dish TV Recharges</a></li>
						<li><a href="index.html#parentVerticalTab2">Tata Sky Recharges</a></li>
						<li><a href="index.html#parentVerticalTab2">Reliance Digital TV Recharges</a></li>
						<li><a href="index.html#parentVerticalTab2">Sun Direct Recharges</a></li>
						<li><a href="index.html#parentVerticalTab2">Videocon D2H Recharges</a></li>	
					</ul>	
			</div>
            <div class="col-md-2 agileits-amet-sed ">
				<h4>Payment Options</h4>
				   <ul class="w3ls-nav-bottom">
						<li>Credit Cards</li>
						<li>Debit Cards</li>
						<li>Any Visa Debit Card (VBV)</li>
						<li>Direct Bank Debits</li>
						<li>Cash Cards</li>	
					</ul>	
			</div>
		<div class="clearfix"> </div>
		</div>
    </div>
	<div class="w3l-footer-bottom">
		<div class="container-fluid">
			<div class="col-md-4 w3-footer-logo">
				<h2><a href="index.html">ONLINE RECHARGE</a></h2>
			</div>
			<div class="col-md-8 agileits-footer-class">
				<p >Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
		<div class="clearfix"> </div>
	 	</div>
	</div>
</footer>
<!--//footer-->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
			<script type="text/javascript">
				$(document).ready(function() {
					/*
						var defaults = {
						containerID: 'toTop', // fading element id
						containerHoverID: 'toTopHover', // fading element hover id
						scrollSpeed: 1200,
						easingType: 'linear' 
						};
					*/
										
					$().UItoTop({ easingType: 'easeOutQuart' });
										
					});
			</script>
			<!-- start-smoth-scrolling -->
			<script type="text/javascript" src="js/move-top.js"></script>
			<script type="text/javascript" src="js/easing.js"></script>
			<script type="text/javascript">
				jQuery(document).ready(function($) {
					$(".scroll").click(function(event){		
						event.preventDefault();
						$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
					});
				});
			</script>
			<!-- start-smoth-scrolling -->
		<!-- //here ends scrolling icon -->
</body>
<!-- /body -->
</html>
<!-- /html -->