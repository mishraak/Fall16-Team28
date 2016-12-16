//loading the 'login' angularJS module

var login = angular.module('login', ['ui.router','ngRoute','ngResource','ngCookies']);
login.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
		$locationProvider.html5Mode(true);
		console.log("view will be injected");
		$stateProvider.state('index', {	
			url : '/elk_dashboard',
			
		}).state('home', {	
			url : '/elk_dashboard_landing',
			
		}).state('home1', {	
			url : '/elk_dashboard_landing1',
			
		}).state('home2', {	
			url : '/elk_dashboard_landing2',
			
		}).state('home3', {	
			url : '/elk_dashboard_landing3',
			
		}).state('home4', {	
			url : '/elk_dashboard_landing4',
			
		});
		$urlRouterProvider.otherwise('/');
	});
//defining the login controller
var style={'background-color':'blue'};
login.controller('login', function($scope, $http,$state,$window,$document,$timeout,$interval) {	
		
		$scope.style=style;
	$scope.color="green";
	$scope.invalid_login=true;
	$scope.login=true;
	$scope.login_header=$window.localStorage.getItem("login_header");
	$scope.temp="testing the call";
	console.log($scope.temp);
	$scope.check_login=function(){
		console.log($scope.password);
		if($scope.username=="admin" && $scope.password=="admin")
		{
			$window.localStorage.setItem("login_header","Admin");
			$window.location.href="http://localhost:3000/elk_dashboard_landing";
			
		}
		else{
			$scope.invalid_login=false;
		}
	};
	$scope.months=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
	
	
	$scope.check_system_status=function(){
		console.log("Get call here");
		$http({
			method:"get",
			url:'//127.0.0.1:9200/_cluster/health',
			data:{}
		}).success(function(data){
			$scope.status_response=data;
			$scope.style={'background-color':data.status};
			console.log(data.status);
		}).error(function(error){
			$scope.status_response=error;
			$scope.style={'background-color':'red'};
		});
	};
	$interval($scope.check_system_status, 10000);
	
	$scope.landing0=function(){
		$window.location.href="http://localhost:3000/elk_dashboard_landing";
	};
	
	$scope.landing1=function(){
		$window.location.href="http://localhost:3000/elk_dashboard_landing1";
	};
	
	$scope.landing2=function(){
		$window.location.href="http://localhost:3000/elk_dashboard_landing2";
	};
	
	$scope.landing3=function(){
		$window.location.href="http://localhost:3000/elk_dashboard_landing3";
	};
	
	$scope.landing4=function(){
		$window.location.href="http://localhost:3000/elk_dashboard_landing4";
	};
	
	$scope.project=function(){
		$window.location.href="http://localhost:3000/project_team_info";
	};
	
	$scope.logout=function(){
		$window.location.href="http://localhost:3000/elk_dashboard";
	};
	
});
