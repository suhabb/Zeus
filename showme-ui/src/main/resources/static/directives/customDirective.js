(function(){

	var app = angular.module('customDirectiveApp', []);
	app.controller("customDirectiveAppCtrl", function ($scope) {
		$scope.products = [
		{ name: "Apples", category: "Fruit", price: 1.20, expiry: 10 },
		{ name: "Bananas", category: "Fruit", price: 2.42, expiry: 7 },
		{ name: "Pears", category: "Fruit", price: 2.02, expiry: 6 }
		];

		$scope.incrementPrices = function () {
			for (var i = 0; i < $scope.products.length; i++) {
				$scope.products[i].price++;
			}
		}

	});


	app.directive('unorderedList', function(){
		// Runs during compile
		return {
            // name: '',
            // priority: 1,
            // terminal: true,
            // scope: {}, // {} = isolate, true = child, false/undefined = no change
            // controller: function($scope, $element, $attrs, $transclude) {},
            // require: 'ngModel', // Array = multiple requires, ? = optional, ^ = check parent elements
            // restrict: 'A', // E = Element, A = Attribute, C = Class, M = Comment
            // template: '',
            // templateUrl: '',
            // replace: true,
            // transclude: true,
            // compile: function(tElement, tAttrs, function transclude(function(scope, cloneLinkingFn){ return function linking(scope, elm, attrs){}})),
            link: function (scope, element, attrs) {
            	var data = scope[attrs["unorderedList"]];
            	var propertyExpression = attrs["listProperty"];
            	if (angular.isArray(data)) {
            		var listElem = angular.element("<ul>");
            		element.append(listElem);
            		for (var i = 0; i < data.length; i++) {
            			(function () {
            				var itemElement = angular.element('<li>');
            				listElem.append(itemElement);
            				var index = i;
            				var watcherFn = function (watchScope) {
            					return watchScope.$eval(propertyExpression, data[index]);
            				}
            				scope.$watch(watcherFn, function (newValue, oldValue) {
            					itemElement.text(newValue);
            				});
            			}());
            		}
            	}

            }
        }
    });

    



})();