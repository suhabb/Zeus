(function(){


/**
* scopesAndCntrl Module
*
* Description
*/
angular.module('scopesApp', [])
.controller('scopesCtrl', function($scope,$rootScope){

	$scope.cities = ["London", "New York", "Paris"];
	$scope.city = "London";


	$scope.getCountry = function (city) {
		switch (city) {
			case "London":
			return "UK";
			case "New York":
			return "USA";
		}
	}

	$scope.$on("zipCodeUpdated", function (event, args) {
		$scope[args.type] = args.zipCode;
	});

	$scope.addresses = {};
	$scope.setAddress = function (type, zip) {
		$rootScope.$broadcast("zipCodeUpdated", {
			type: type, zipCode: zip
		});
		$scope.addresses[type] = zip;
	}
	$scope.copyAddress = function () {
		$scope.shippingZip = $scope.billingZip;
	}

});






})();