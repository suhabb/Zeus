(function(){

	var app = angular.module('complexDirectiveApp', []);
	app.controller("complexDirectiveAppCtrl", function ($scope) {
		$scope.products = [
		{ name: "Apples", category: "Fruit", price: 1.20, expiry: 10 },
		{ name: "Bananas", category: "Fruit", price: 2.42, expiry: 7 },
		{ name: "Pears", category: "Fruit", price: 2.02, expiry: 6 }
		];

		$scope.vegetables = [
		{ name: "Palak", category: "Veg", price: 4.20, expiry: 10 },
		{ name: "Leave", category: "veg", price: 8.42, expiry: 7 },
		{ name: "Olive", category: "veg", price: 9.02, expiry: 6 }
		];
		$scope.data = { name: "Adam" };

	});

	app.directive("unorderedList", function () {
		return {
			link: function (scope, element, attrs) {
				var data = scope[attrs["unorderedList"] || attrs["listSource"]];
				var propertyExpression = attrs["listProperty"] || "price | currency";
				if (angular.isArray(data)) {
					var listElem = angular.element("<ul>");
					if (element[0].nodeName == "#comment") {
						element.parent().append(listElem);
					} else {
						element.append(listElem);
					}
					for (var i = 0; i < data.length; i++) {
						var itemElement = angular.element("<li>")
						.text(scope.$eval(propertyExpression, data[i]));
						listElem.append(itemElement);
					}
				}
			},
			restrict: "EACM"
		}
	});

	app.directive("templateList", function () {
		return {
			link: function (scope, element, attrs) {
				scope.data = scope[attrs["templateList"]];
			},
			restrict: "A",
			template: "<ul><li ng-repeat='item in data'>{{item.name}}</li></ul>"
		}


	});

	/*	The replace property doesn’t just replace the element with the template; it also transfers the attributes from the
element to the template content. In this case, this means the table and table-striped Bootstrap classes are applied
to the table element,*/

app.directive("templateurlList", function () {
	return {
		link: function (scope, element, attrs) {
			scope.data = scope[attrs["templateurlList"]];
			console.log(eval(scope.data));
		},
		restrict: "A",
		templateUrl: function (elem, attrs) {
			return attrs["template"] == "table" ?
			"../view/itemTemplate.html" : "../view/itemTemplate.html";
		},

		replace: true
	}
});
/*You don’t have to create controllers to give directives their own scopes. A more elegant approach is to ask AngularJS
to create a scope for each instance of the directive by setting the scope definition object property to true*/
app.directive("scopeDemo", function () {
	return {
		template:
		"<div class='panel-body'>Name: <input ng-model=name /></div>",
		scope: {
			//local: "@nameprop"
			local: "=nameprop"
		}
	}
});






})();