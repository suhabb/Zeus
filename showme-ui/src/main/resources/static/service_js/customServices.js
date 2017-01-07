(function(){


	angular.module("customServiceApp", ['customCountDirective']).config(function (logServiceProvider) {
		logServiceProvider.debugEnabled(true).messageCounterEnabled(false);
	})
	.controller('customServiceCtrl', ['$scope','loggingService', function($scope,loggingService){
		$scope.data = {
			cities: ["London", "New York", "Paris"],
			totalClicks: 0
		};
		$scope.$watch('data.totalClicks', function (newVal) {
			console.log("Total click count: " + newVal);
			loggingService.log("LOG_SEVICE:"+newVal);
		});
		
	}]);


	angular.module("customServiceApp")
	.service('loggingService', function(){
		return {
			messageCount: 0,
			log: function (msg) {
				console.log("Debug: " + (this.messageCount++) + " " + msg);
			}
		};
		
	});

	angular.module("customServiceApp")
	.provider('logService',function(){
			var counter = true;
			var debug = true;
			return {
				messageCounterEnabled: function (setting) {
					if (angular.isDefined(setting)) {
						counter = setting;
						return this;
					} else {
						return counter;
					}
				},
				debugEnabled: function(setting) {
					if (angular.isDefined(setting)) {
						debug = setting;
						return this;
					} else {
						return debug;
					}
				},
				$get: function () {
					return {
						messageCount: 0,
						log: function (msg) {
							if (debug) {
								console.log("(LOG"
									+ (counter ? " + " + this.messageCount++ + ") " : ") ")
									+ msg);
							}
						}
					};
				}
			}

		});









})();