(function() {

    var app = angular.module('passConfigApp', []);

    app.controller('passAppController', ['$scope', function($scope) {
        $scope.text = "I am in Parent SCope";
    }]);

    app.directive('myWidget', [function() {

        var linkFunction = function(scope, iElement, iAttrs) {
            scope.text = iAttrs["myWidget"];

        };
        return {
            restrict: 'EA',
            template: "<p>{{text}}</p>",
            link: linkFunction
        };
    }]);

    app.directive('myWidget2', [function() {
        return {
            restrict: 'E',
            template: "<p> {{text}} yes {{info}}</p>",
            scope: {
                info: "@info",
                text: "=text"
            },
            link: function(scope, iElement, iAttrs) {
                console.log(iElement);
                console.log(iAttrs);
                scope.text = iAttrs["text"];
                console.log(scope.text);
                scope.text = "Changed";
                scope.info = "INFO Changed";
            }
        };
    }]);


    app.directive("basket", function() {
        return {
            restrict: "E",
            controller: function($scope, $element, $attrs) {
                $scope.content = [];

                this.addApple = function() {
                    $scope.content.push("apple");
                };

                this.addOrange = function() {
                    $scope.content.push("orange");
                };
            },
            link: function(scope, element) {
                element.bind("mouseenter", function() {
                    console.log(scope.content);
                });
            }
        };
    });

    app.directive("apple", function() {
        return {
            require: "basket",
            link: function(scope, element, attrs, basketCtrl) {
                basketCtrl.addApple();
            }
        };
    });

    app.directive("orange", function() {
        return {
            require: "basket",
            link: function(scope, element, attrs, basketCtrl) {
                basketCtrl.addOrange();
            }
        };
    });

})();

/*<!-- Solution
The link function has access to the element and its attributes. It is therefore straightforward to set
the scope to the text passed as the attributes value and use this in the template evaluation.
The scope context is important though. The text model we changed might already be defined in the
parent scope and used in another part of your app. In order to isolate the context and thereby use it
only locally inside your directive, we have to return an additional scope attribute.

Basket is the example directive that demonstrates an API using the controller function, whereas the
apple and orange directives augment the basket directive. They both define a dependency to the
basket controller with the require attribute. The link function then gets basketCtrl injected.
Note how the basket directive is defined as an HTML element and the apple and orange directives
are defined as HTML attributes (the default for directives). This demonstrates the typical use case
of a reusable component augmented by other directives.
Now there might be other ways of passing data back and forth between directives - we have seen
the different semantics of using the (isolated) context in directives in previous recipes - but what’s
especially great about the controller is the clear API contract it lets you define.
*/
