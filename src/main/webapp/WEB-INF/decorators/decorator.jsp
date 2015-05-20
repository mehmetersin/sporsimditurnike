<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!doctype html>
<html lang="en">
<head>
<title><decorator:title /></title>
<decorator:head />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	
	
	<!--  <script src="${pageContext.request.contextPath}/resources/js/jKeyboard.js"></script> -->
	

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body
	<decorator:getProperty property="body.ng-app" writeEntireProperty="true"/>>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div align="center" class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				
			</div>
		</div>
	</div>

	<div class="container" style="padding-top: 60px">
		<div class="starter-template">
			<h1>     SporSimdi</h1>
			<p class="lead">
				Hosgeldiniz.<br>
				
			</p>
		</div>

		<div class="body">
			<h1>Giris Kodunu Giriniz</h1>
			<decorator:body />
		</div>

	</div>
	<!-- /.container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>