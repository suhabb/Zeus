(function(){


	angular.module('sportsStoreAdmin')
	.constant("authUrl", "http://localhost:8980/sports/admin/login")
	.constant('ordersUrl', "http://localhost:8980/sports/admin/orders")
	.controller("authCtrl", function($scope,$http,$location,authUrl){
		$scope.authenticate=function(user,password){

			$http.post(authUrl,{
				username:user,
				password:password

			},{
				withCredentials:true
			}).success(function(data){
				$location.path("/main")
			}).error(function(error){
				$scope.authenticationError = error;
			});
		}

	}).controller("mainCtrl", function($scope) {
		$scope.screens = ["Products", "Orders"];
		$scope.current = $scope.screens[0];
		$scope.setScreen = function (index) {
			$scope.current = $scope.screens[index];
		};
		$scope.getScreen = function () {
			return $scope.current == "Products"
			? "../view/adminProducts.html" : "../view/adminOrders.html";
		};
	}).controller('ordersCtrl', function($scope,$http,ordersUrl){

		$http.get(ordersUrl, {withCredentials : true})
		.success(function (data) {
			$scope.orders = data;
		})
		.error(function (error) {
			$scope.error = error;
		});

		$scope.selectedOrder;
		
		$scope.selectOrder = function(order) {
			$scope.selectedOrder = order;
		};

		$scope.calcTotal = function(order) {
			var total = 0;
			for (var i = 0; i < order.productDTO.length; i++) {
				total +=
				order.productDTO[i].count * order.productDTO[i].price;
			}
			return total;
		}
		
	});



})();

