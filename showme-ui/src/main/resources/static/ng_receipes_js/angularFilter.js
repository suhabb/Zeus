(function() {

    var app = angular.module('filterApp', []);
    app.filter("reverse", function() {

        return function(input, option) {
            var result = "";
            input = input || "";
            if (option == true) {
                for (var i = 0; i < input.length; i++) {
                    result = input.charAt(i) + result;
                }
            }

            return result;


        };


    });





})();

/*<!-- Solution
Angular’s filter function expects a filter name and a function as params. The function must return
the actual filter function where you implement the business logic. In this example it will only have
an input param. The result will be returned after the for loop has reversed the input.
*/
