(function(){

	var app = angular.module('receipsApp', []);
	app.controller('ShowHideCtrl', ['$scope', function($scope){

		$scope.visible = true;

   		 $scope.toggle = function() {
        	$scope.visible = !$scope.visible;
    	};
	
	}]);

	app.directive('show', [function () {
		return {
			restrict: 'A',
			link: function (scope, iElement, iAttrs) {
					scope.$watch(iAttrs.show, function(value){
						iElement.css('display',value ?'':'none');
					});
			}
		};
	}]);



})();

/*<!-- Solution
Create a custom directive which renders your Hello World snippet.s The browser will only show the “Hello World” paragraph if the checkbox is checked and will hide
it otherwise.The directive implementation returns a link function which defines the directive’s behavior. It gets
passed the scope, the HTML element and the HTML attributes. Since we passed the visible
variable as an attribute to our show directive, we can access it directly via attributes.show. But,
since we want to respond to visible variable changes automatically we have to use the $watch
service, which provides us with a function callback whenever the value changes. In this callback we
change the CSS display property to either blank or none to hide the HTML element.-->*/


