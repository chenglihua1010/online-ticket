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
<title>Plans</title>
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
			<span class="agile-breadcrumbs"><a href="index.html"><i class="fa fa-home home_1"></i></a> / <span>Plans</span></span>
		</div>
	</div>
	<!-- //breadcrumbs -->
	<!-- plans -->
<div class="w3layouts-content w3layouts-plans">
    <div class="container">
			<h3 class="w3-head">Plans</h3>
	<!--Horizontal Tab-->
        <div id="parentHorizontalTab">
            <ul class="resp-tabs-list hor_1">
                <li>FULLTT</li>
                <li>TOPUP</li>
                <li>3G/4G</li>
                <li>SPL/RATE CUTTER</li>
                <li>2G</li>
            </ul>
            <div class="resp-tabs-container hor_1">
                <div>
                    <ul class="w3ls-plan">
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 15</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs.15</p>
                                    <p><strong>Validity: 2days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 25</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 25 - 5 Local SMS free - Free SMS valid for 1 day(s)</p>
                                    <p><strong>Validity: 3days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 55</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 55 - 5 Local SMS free - Free SMS valid for 1 day(s)</p>
                                    <p><strong>Validity: 5days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 65</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 65 - 5 Local SMS free - Free SMS valid for 2 day(s) - Applicable only for 4G</p>
                                    <p><strong>Validity: 28days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 150</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 150 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 195</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 198 - 5 Local and National SMS free - Free SMS valid for 2 day(s)</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 500</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 500</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 555</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Full Talktime Rs. 555 - 5 Local SMS free - Free SMS valid for 3 day(s)</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                                            </ul>
                </div>
                <div>
                    <ul class="w3ls-plan">
                        
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 10</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 7.70 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 20</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 15.39 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 30</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 23.09 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 50</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 40.48 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 60</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 49.17 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 70</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 57.87 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 80</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 66.70 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 100</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Talktime Rs. 83.96 - Applicable only for 4G</p>
                                    <p><strong>Validity: Unlimited Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                                            </ul>
                </div>
                <div>
                    <ul class="w3ls-plan">
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 11</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>10 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 1day</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 18</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>50 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 39</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>200 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 28days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 51</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>100 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 6days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 54</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>94 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 67</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>203 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 89</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>250 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 30days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 97</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>169 MB - Applicable only for 4G - For 4G users only</p>
                                    <p><strong>Validity: 14days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                                            </ul>
                </div>
                <div>
                    <ul class="w3ls-plan">
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 7</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Local Onnet Mobile @ Rs. 0.10/min - Local Offnet Mobile @ Rs. 0.25/min - Local Onnet Landline @ Rs. 0.10/min - Local Offnet Landline @ Rs. 0.25/min - STD Onnet Mobile @ Rs. 0.10/min - STD Offnet Mobile @ Rs. 0.25/min - STD Onnet Landline @ Rs. 0.10/min - STD Offnet Landline @ Rs. 0.25/min</p>
                                    <p><strong>Validity: 1day</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 8</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Local Onnet Mobile @ Rs. 0.01/6 sec - Local Offnet Mobile @ Rs. 0.01/2 sec - Local Onnet Landline @ Rs. 0.01/6 sec - Local Offnet Landline @ Rs. 0.01/2 sec - STD Onnet Mobile @ Rs. 0.01/6 sec - STD Offnet Mobile @ Rs. 0.01/2 sec - STD Onnet Landline @ Rs. 0.01/6 sec - STD Offnet Landline @ Rs. 0.01/2 sec</p>
                                    <p><strong>Validity: 1day</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 9</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>60 Local Onnet min free</p>
                                    <p><strong>Validity: 1day</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 14</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>150 Local and National SMS free - Applicable only for 4G</p>
                                    <p><strong>Validity: 14days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 18</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Local Onnet Mobile @ Rs. 0.15/min - Local Offnet Mobile @ Rs. 0.35/min - STD Mobile @ Rs. 0.35/min</p>
                                    <p><strong>Validity: 3Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 31</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>3000 Local sec free</p>
                                    <p><strong>Validity: 5Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 37</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>Local @ Rs. 0.30/min - Applicable only for 4G</p>
                                    <p><strong>Validity: 15Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 49</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>4800 Local and STD Mobile sec free</p>
                                    <p><strong>Validity: 7Days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                                            </ul>
                </div>
                <div>
                    <ul class="w3ls-plan">
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 11</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>10 MB</p>
                                    <p><strong>Validity: 1day</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 18</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>50 MB</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 39</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>200 MB</p>
                                    <p><strong>Validity: 28days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 51</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>100 MB</p>
                                    <p><strong>Validity: 6days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 54</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>94 MB</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 67</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>203 MB</p>
                                    <p><strong>Validity: 7days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                         <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 89</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>250 MB</p>
                                    <p><strong>Validity: 30days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                        <li>
                            <a href="pay.jsp">
                                <div class="agile-price">
                                   <span>Rs. 97</span> 
                                </div>
                                <div class="valid-agileits">
                                    <p>169 MB</p>
                                    <p><strong>Validity: 14days</strong></p>
                                </div>
                                <div class="clearfix"></div>
                            </a>
                        </li>
                                            </ul>
                </div>
            </div>
        </div>
    </div>
 </div>
	
	<!--Plug-in Initialisation-->
	<script type="text/javascript">
    $(document).ready(function() {
        //Horizontal Tab
        $('#parentHorizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
    });
</script>
	<!-- // plans -->

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
<!-- easy-responsive-tabs -->    
<link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
<script src="js/easyResponsiveTabs.js"></script>
<!-- //easy-responsive-tabs --> 
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