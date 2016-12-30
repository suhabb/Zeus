(function(){

	var app=angular.module("sportsStore")
	.constant("dataUrl", "http://localhost:8980/docs/sports_store.json")
	.constant('orderUrl', "http://localhost:8980/sports/store/order")
	.controller('sportsStoreCtrl', function($scope,$http,$location,dataUrl,orderUrl,cartService){
		$scope.data = {};
		
		$http.get(dataUrl).success(function (data) {
			$scope.data.products = data;
		}).error(function (error) {
			$scope.data.error = error;
		});

		$scope.sendOrder=function(shippingDetails){
			var order=angular.copy(shippingDetails);
			order.products=cartService.getProducts();
			$http.post(orderUrl,order).success(function(data){
				$scope.data.orderId = data.id;
				cartService.getProducts().length = 0;
			}).error(function (error) {
				$scope.data.orderError = error;
			}).finally(function () {
				$location.path("/complete");
			});
		}

		});









})();

