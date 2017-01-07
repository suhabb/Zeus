(function(){

	

	angular.module("domApiApp", [])
	.controller("apiDomCtrl",['$scope','$window','$document', '$interval','$exceptionHandler',
		function ($scope, $window,$document,$interval,$exceptionHandler) {
			$document.find("button").on("click", function (event) {
				$window.alert(event.target.innerText);
			});

			$interval(function () {
				$scope.time = new Date().toTimeString();
			});

			$scope.throwEx = function () {
				try {
					throw new Error("Triggered Exception");
				} catch (ex) {
					$exceptionHandler(ex, "Button Click");
				}
			}

		}]).factory("$exceptionHandler", function ($log) {
			return function (exception, cause) {
				$log.error("Message: " + exception.message + " (Cause: " + cause + ")");
			}
		});


})();/**
 * Created by suhail on 02/01/2017.
 */
