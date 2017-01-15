(function(){

	var app = angular.module('shareModelApp', []);

	app.controller('MyCtrl', ['$scope', function($scope){
		$scope.name = "Peter";
  $scope.user = {
    name: "Parker"
  };
		
	}]);
app.controller("MyNestedCtrl", function($scope) { });

})();

/*<!-- Solution
Use Javascript objects instead of primitives or direct $parent scope references.
Our example template uses a controller MyCtrl and a nested controller MyNestedCtrl:
All the default values are defined in MyCtrl which is the parent of MyNestedCtrl. When making
changes in the first input field, the changes will be in sync with the other input fields bound to the
name variable. They all share the same scope variable as long as they only read from the variable.
If you change the nested value, a copy in the scope of the MyNestedCtrl will be created. From now
on, changing the first input field will only change the nested input field which explicitly references
the parent scope via $parent.name expression.
The object-based value behaves differently in this regard. Whether you change the nested or the
MyCtrl scopes input fields, the changes will stay in sync. In Angular, a scope prototypically inherits
properties from a parent scope. Objects are therefore references and kept in sync. Whereas primitive
types are only in sync as long they are not changed in the child scope.

*/