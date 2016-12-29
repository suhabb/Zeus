(function(){

	var app=angular.module("sportsStore")
	.constant("dataUrl", "http://localhost:8980/docs/sports_store.json")
	.controller('sportsStoreCtrl', function($scope,$http,dataUrl){
		$scope.data = {};
		
		$http.get(dataUrl).success(function (data) {
			$scope.data.products = data;
		}).error(function (error) {
			$scope.data.error = error;
		});

	});			









})();

