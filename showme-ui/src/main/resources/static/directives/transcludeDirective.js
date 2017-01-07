(function(){


	angular.module("transcludeDirectiveApp", [])
	.directive("panel", function () {
		return {
			link: function (scope, element, attrs) {
				scope.dataSource = "directive";
			},
			restrict: "E",
			scope: true,
			template: function () {
				return angular.element(
					document.querySelector("#template")).html();
			},
			transclude: true
		}
	})
	.controller("transcludeDirectiveCtrl", function ($scope) {
		$scope.dataSource = "controller";
	});




})();