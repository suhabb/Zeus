(function(){

	var app = angular.module('scopeChangeApp', []);

	app.controller('ScopeChangeCtrl', ['$scope', function($scope){
		$scope.name="";

		$scope.$watch("name",function(newValue,oldValue){
			if($scope.name.length > 0)
			{
				$scope.greeting="Greetings"+$scope.name;
			}
		});
		
	}]);


})();

/*<!-- Solution
The first argument name of the $watch function is actually an Angular expression, so you can use
more complex expressions (for example: [value1, value2] | json) or even a Javascript function..-->
The second argument is a function which gets called whenever the expression evaluation returns
a different value. The first parameter is the new value and the second parameter the old value.
Internally, this uses angular.equals to determine equality which means both objects or values pass
the === comparison

*/