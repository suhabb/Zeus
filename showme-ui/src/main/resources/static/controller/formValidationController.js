(function(){

	
	angular.module('formValidationApp', [])
	.controller('formValidationCtrl', function($scope){

		$scope.todos = [
		{ id: 100, place: "Store", action: "Get groceries", complete: false },
		{ id: 200, place: "Home", action: "Call plumber", complete: false },
		{ id: 300, place: "Store", action: "Buy running shoes", complete: true }];

		$scope.addUser=function(userDetails){
			$scope.message=userDetails.name
			+ " (" + userDetails.email + ") (" + userDetails.agreed + ")"

		}
		$scope.message = "Ready";
		$scope.requireValue = true;
		$scope.matchPattern = new RegExp("^[a-z]");
		$scope.getError = function(error){

			if(angular.isDefined(error)){
				if(error.required){
					return "Please enter a value";
				} else if (error.email) {
					return "Please enter a valid email address";
				}

			}

		}

	});

})();