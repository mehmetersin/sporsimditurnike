<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
 
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>



<body ng-app="myapp">

	<div id="MainWrap" ng-controller="MyController" tabindex="0" ng-init="inputState=false">
		<input type="text" name="girisKodu" id="girisKodu" ng-model="myForm.girisKodu" 
			ng-enter="enterPressed()" autofocus="true"   >
		<br />

		<div class="bs-example" ng-init="fail=false">
			<div class="alert alert-danger alert-error" ng-show="fail"
				style="clear: both;">
				<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Hata!</strong>
				Yalnis Giris , tekrar deneyiniz.
			</div>
		</div>

		<div class="bs-example" ng-init="fail=false">
			<div class="alert alert-warning" ng-show="success"
				style="clear: both;">
				<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>{{responseMessage}}</strong>

			</div>
		</div>

	</div>
	
<video width="400" controls>
  <source src="/SporSimdiTurnikeRpi/resources/mov_bbb.mp4" type="video/mp4">
  Your browser does not support HTML5 video.
</video>

	<script>
		var app = angular.module("myapp", []);

		 app.directive('ngEnter', function() {
			return function(scope, element, attrs) {
				element.bind("keydown keypress", function(event) {
					if (event.which === 13) {
						scope.$apply(function() {
							scope.$eval(attrs.ngEnter);
						});

						event.preventDefault();
					}
				});
			};
		}); 

		function MyController($scope, $http, $timeout) {

			$scope.accessCodeEntered = function() {

				if ($scope.inputState){
					document.getElementById("girisKodu").value='';
					return;
				}
				
				$scope.inputState = true;

				var textValue = document.getElementById("girisKodu").value;
				
				var response = $http.get('/SporSimdiTurnikeRpi/access/'
						+ textValue);

				response.success(function(data, status, headers, config) {
					document.getElementById("girisKodu").value='';
					$scope.success = false;
					$scope.fail = false;

					var resp = JSON.parse(angular.toJson(data));

					var code = resp.resultCode;

					$scope.responseMessage = resp.message;

					if (code == "SUCCESS" || code == "FAIL") {
						$scope.success = true;
					} else {
						$scope.fail = true;
					}

					$timeout( function(){ $scope.clearDisplay(); }, 2000);

				});

				response.error(function(data, status, headers, config) {
					$scope.fail = true;
					$timeout( function(){ $scope.clearDisplay(); }, 2000);
					
				});

			};

			$scope.clearDisplay = function() {

				$scope.fail = false;
				$scope.success = false;
				
				$scope.inputState = false;
				
				
			};

			$scope.enterPressed = function() {

				if ($scope.inputState){
					document.getElementById("girisKodu").value='';
					return ;
				}
				

				$scope.accessCodeEntered();

			};

			
			
		}
		
		
		
		
	
		
		
			
		
	</script>

</body>
</html>