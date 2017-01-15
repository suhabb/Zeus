(function() {

    var app = angular.module('changeDOMApp', []);

  	app.directive('myWidget', [function () {

  		var linkChangeDOM=function (scope, iElement, iAttrs) {
  			var paragragh= iElement.children()[0];
  			$(paragragh).on("click",function(){
  				$(this).css({"background-color":"red"});
  				$(this).text("Hello this Uk")
  			});
  				
  		};
  		return {
  			restrict: 'E',
  			link: linkChangeDOM
  		};
  	}])

})();

/*<!-- Solution
In the HTML document we use the new directive as an HTML element my-widget, which can be
found in the Javascript code as myWidget again. The directive function returns a restriction and a
link function.Whether you use the attribute or element mechanism will depend on your use case. Generally
speaking one would use the element mechanism to define a custom reusable component. The
attribute mechanism would be used whenever you want to “configure” some element or enhance it
with more behavior. Other available options are using the directive as a class attribute or a comment.Whether you use the attribute or element mechanism will depend on your use case. Generally
speaking one would use the element mechanism to define a custom reusable component. The
attribute mechanism would be used whenever you want to “configure” some element or enhance it
with more behavior. Other available options are using the directive as a class attribute or a comment
*/
