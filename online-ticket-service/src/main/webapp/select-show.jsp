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
<title>Select Show</title>
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
			<span class="agile-breadcrumbs"><a href="index.html"><i class="fa fa-home home_1"></i></a> / <span>Select Show</span></span>
		</div>
	</div>
	<!-- //breadcrumbs -->

	<!-- Movies-select-show -->
	<div class="agile-movies-select-show w3layouts-content">
    <div class="container">        
        <h3 class="w3-head">Select show</h3>
        <div class="now-showing-list">
		<div class="col-md-4 movies-by-category movie-booking">
			<div class="movie-ticket-book">
					<img src="images/movie-show.jpg" alt="" />
					<div class="bahubali-details">
						<h4>Release Date:</h4>
						<p>Jul 10, 2018</p>
						<h4>Duration:</h4>
						<p>2 hrs 50 mins</p>
						<h4>Director:</h4>
						<p>Director Name.</p>
						<h4>Language:</h4>
						<p>Language</p>
						<h4>Genre:</h4>
						<p>Action, Romance</p>
						<h4>Cast & Crew:</h4>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap.</p>
					</div>
				</div>
			</div>
		<div class="col-md-8 movies-dates">	
			<div class="movie-date-selection">
				<ul>
					<li class="location">
						<i class="fa fa-map-marker"></i>Theater Name: Location
					</li>
                    <li class="time">
                        <span>Show Time:</span>
                    </li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">11:00 AM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">3:00 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">6:20 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">9:00 PM</a>
					</li>
				</ul>
			</div>
			<div class="movie-date-selection">
				<ul>
					<li class="location">
						<i class="fa fa-map-marker"></i>Theater Name: Location
					</li>
                    <li class="time">
                        <span>Show Time:</span>
                    </li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">11:00 AM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">3:00 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">6:20 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">9:00 PM</a>
					</li>
				</ul>
			</div>
			<div class="movie-date-selection">
				<ul>
					<li class="location">
						<i class="fa fa-map-marker"></i>Theater Name: Location
					</li>
                    <li class="time">
                        <span>Show Time:</span>
                    </li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">11:00 AM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">3:00 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">6:20 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">9:00 PM</a>
					</li>
				</ul>
			</div>
			<div class="movie-date-selection">
				<ul>
					<li class="location">
						<i class="fa fa-map-marker"></i>Theater Name: Location
					</li>
                    <li class="time">
                        <span>Show Time:</span>
                    </li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">11:00 AM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">3:00 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">6:20 PM</a>
					</li>
					<li class="time">
						<a href="#" data-toggle="modal" data-target="#myModalseatselect">9:00 PM</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
             <div class="modal fade" id="myModalseatselect" role="dialog">
			<div class="modal-dialog">
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
					      
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
					<h4 class="modal-title">
                    Select your seat now</h4>
		<div class="demo-agile-screen">
			<div id="seat-map">
				<div class="front">SCREEN</div>					
			</div>
			<div class="booking-details">
				<ul class="book-left">
					<li>Movie </li>
					<li>Time </li>
					<li>Tickets</li>
					<li>Total</li>
					<li>Seats :</li>
				</ul>
				<ul class="book-right">
					<li>: Movie Name</li>
					<li>: May 30, 21:00</li>
					<li>: <span id="counter">0</span></li>
					<li>: <b><i>$</i><span id="total">0</span></b></li>
				</ul>
				<div class="clear"></div>
				<ul id="selected-seats" class="scrollbar scrollbar1"></ul>
			
						
				<a href="pay.jsp"><button class="checkout-button">Pay Now</button></a>
				<div id="legend"></div>
			</div>
			<div style="clear:both"></div>
	    </div>

			<script type="text/javascript">
				var price = 10; //price
				$(document).ready(function() {
					var $cart = $('#selected-seats'), //Sitting Area
					$counter = $('#counter'), //Votes
					$total = $('#total'); //Total money
					
					var sc = $('#seat-map').seatCharts({
						map: [  //Seating chart
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'__________',
							'aaaaaaaa__',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'__aaaaaa__'
						],
						naming : {
							top : false,
							getLabel : function (character, row, column) {
								return column;
							}
						},
						legend : { //Definition legend
							node : $('#legend'),
							items : [
								[ 'a', 'available',   'Available' ],
								[ 'a', 'unavailable', 'Sold'],
								[ 'a', 'selected', 'Selected']
							]					
						},
						click: function () { //Click event
							if (this.status() == 'available') { //optional seat
								$('<li>Row'+(this.settings.row+1)+' SeatVo'+this.settings.label+'</li>')
									.attr('id', 'cart-item-'+this.settings.id)
									.data('seatId', this.settings.id)
									.appendTo($cart);

								$counter.text(sc.find('selected').length+1);
								$total.text(recalculateTotal(sc)+price);
											
								return 'selected';
							} else if (this.status() == 'selected') { //Checked
									//Update Number
									$counter.text(sc.find('selected').length-1);
									//update totalnum
									$total.text(recalculateTotal(sc)-price);
										
									//Delete reservation
									$('#cart-item-'+this.settings.id).remove();
									//optional
									return 'available';
							} else if (this.status() == 'unavailable') { //sold
								return 'unavailable';
							} else {
								return this.style();
							}
						}
					});
					//sold seat
					sc.get(['1_2', '4_4','4_5','6_6','6_7','8_5','8_6','8_7','8_8', '10_1', '10_2']).status('unavailable');
						
				});
				//sum total money
				function recalculateTotal(sc) {
					var total = 0;
					sc.find('selected').each(function () {
						total += price;
					});
							
					return total;
				}
			</script>
			<script src="js/jquery.seat-charts.js"></script>

					</div>
				</div>
			</div>
		</div>

	</div>	
    </div>
	</div>
	<!-- //Movies-select-show --> 

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