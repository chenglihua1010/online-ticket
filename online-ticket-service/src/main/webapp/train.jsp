<%@ page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%--日期格式--%>
<%--<%@ taglib uri="/struts-tags" prefix="s"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"><!DOCTYPE html>
<!-- html -->
<html>
<!-- head -->
<head>
<title>Train</title>
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
<meta name="keywords" content="Online Recharge Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
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
			<span class="agile-breadcrumbs"><a href="index.html"><i class="fa fa-home home_1"></i></a> / <span>西杭铁路</span></span>
		</div>
	</div>
	<!-- //breadcrumbs -->
	<!-- Trains -->
	<div class="agile-trains w3layouts-content">
     <div class="container">
	<div class="col-md-4 bann-info1">
		<i class="train-icon fa fa-train"></i>
	</div>
	<div class="col-md-5 bann-info">
		<h3>列车查询</h3>
        <div class="book-a-ticket">
							<div class=" bann-info">
								<%--<form>要提交的参数</form> action：submit跳转的方法（路径）或页面  get/pos？t--%>
								<%--<form action="trains-list.jsp" method="post">--%>
								<form action="/trianInfor/findAimTrainInfor" method="post">
									<div class="ban-top">
										<div class="bnr-left">
											<label class="inputLabel">起点：</label>
											<%--隐藏信息--用户账号 仅需id--%>
											<input name="user_phone_num" type="hidden" value="${userInfor.user_phone_num}">
											<input name="user_password" type="hidden" value="${userInfor.user_password}">
											<input name="id" type="hidden" value="${userInfor.id}">
											<%--<input class="city" type="text" placeholder="出发地" required="required" name="train_start_station"/>--%>
											<select  required="required" name="train_start_station">
												<option name="train_start_station">出发地</option>
												<option name="train_start_station" value="西安">西安</option>
												<option name="train_start_station" value="杭州">杭州</option>
												<option data-tokens="BSNL">BSNL</option>

											</select>
										</div>
										
										<div class="bnr-left">
											<label class="inputLabel">终点：</label>
											<%--<input class="city" type="text" placeholder="目的地" required="required" train_end_station/>--%>
											<select class="selectpicker show-tick" data-live-search="true" required="required" name="train_end_station">
												<option name="train_end_station">目的地</option>
												<option name="train_end_station" value="西安">西安</option>
												<option name="train_end_station" value="杭州">杭州</option>
											</select>
										</div>


										<div class="bnr-left">
											<label class="inputLabel">类型：</label>

											<ul>
												<li>
													<label class="inputLabel">高铁/动车</label>
													<input type="checkbox" name="train_type" value="2" checked>
												</li>
												<li>
													<label class="inputLabel">均可</label>
													<input type="checkbox" name="train_type" value="0">
												</li>

												<%--<li>--%>
													<%--<label class="inputLabel">硬座：</label>--%>
													<%--<input type="checkbox" name="checkbox1" value="3">--%>
												<%--</li>--%>

												<%--<li>--%>
													<%--<label class="inputLabel">硬卧：</label>--%>
													<%--<input type="checkbox" name="checkbox1" value="4">--%>
												<%--</li>--%>
											</ul>

										</div>
											<div class="clearfix"></div>
									</div>
									 <div class="ban-bottom">
											<div class="bnr-right">
												<label class="inputLabel">出发日期：</label>
				<input class="date" id="datepicker" type="text" placeholder="出发日期"  required="required" name="train_start_time"/>
												<%--<s:date name="train_start_time" format="yyyy-MM-dd"/>--%>
												<%--<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd" />--%>
											</div>
										 <%--返程--%>
											<%--<div class="bnr-right">--%>
												<%--<label class="inputLabel">返回日期：<span class="opt">&nbsp;(Optional):</span></label>--%>
				<%--<input class="date" id="datepicker1" type="text" placeholder="dd-mm-yyyy" />--%>
											<%--</div>--%>
												<div class="clearfix"></div>
												<!-- start-date-piker -->
												<link rel="stylesheet" href="css/jquery-ui.css">
												<script src="js/jquery-ui.js"></script>
													<script>
														$(function() {
														$( "#datepicker,#datepicker1" ).datepicker();
														});
													</script>
											<!-- /End-date-piker -->
										</div>
									<div class="search">
									     <input type="submit" class="submit" value="查询">
									
									</div>
								</form>
							</div>
					</div>

	</div>
	<div class="clearfix"></div>
</div>
</div>
<!-- //Trains -->

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