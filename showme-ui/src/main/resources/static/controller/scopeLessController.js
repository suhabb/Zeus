(function(){



	angular.module('scopeLessApp', []).controller('scopeLessCtrl',  function(){
		this.dataValue = "Hello, Adam";
		this.reverseText = function () {
			this.dataValue = this.dataValue.split("").reverse().join("");
		}

	});




















})();