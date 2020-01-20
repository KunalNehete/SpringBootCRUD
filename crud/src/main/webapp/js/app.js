var app = angular.module('sampleApp', [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'addhosp.html'
	}).when('/getall', {
		templateUrl : 'getall.html'
	}).when('/addhosp', {
		templateUrl : 'addhosp.html'
	}).otherwise({
		redirectTo : '/'
	});
});

app.controller('getcontroller', function($scope, $http/* , $rootScope */) {

	/* $rootScope.isLoading = false; */

	// list hospital loading at the first time
	$scope.hospitalList = [];
	// selected hospital
	$scope.selectHospital;

	$scope.getfunction = function() {
		/* $rootScope.isLoading = true; */
		var url = "http://localhost:8080/test/hospitals";

		$http.get(url).then(function(response) {
			$scope.hospitalList = response.data
		});
		/* $rootScope.isLoading = false; */
	};

	$scope.addhosp = function() {

		var dataObj = {
			name : $scope.name,
			city : $scope.city,
			rating : $scope.rating
		};
		var res = $http.post('http://localhost:8080/test/addHosp', dataObj)

		/*
		 * res.success(function(data, status, headers, config) { $scope.message =
		 * data; }); res.error(function(data, status, headers, config) {
		 * alert("failure message: " + JSON.stringify({ data : data })); });
		 */

		/*
		 * $scope.name = ''; $scope.city = ''; $scope.rating = '';
		 */
	};

	// the function to select a hospital
	$scope.selectHospital = function(index) {
		if ($scope.hospitalList.length) {
			$scope.selectedHospital = $scope.hospitalList[index];
		}
	};

	// using http PUT to update the changed hospital info
	$scope.updateHospital = function() {
		/* $rootScope.isLoading = true; */
		if ($scope.selectedHospital) {
			// put URL
			var url = 'http://localhost:8080/test/hospital/'
					+ $scope.selectedHospital.id;

			// prepare headers for posting
			var config = {
				headers : {
					'Content-Type' : 'application/json',
					'Accept' : 'text/plain'
				}
			}

			// prepare data for put messages
			var data = $scope.selectedHospital;

			// do posting
			$http.put(url, data, config).then(function(response) {
				$scope.error = false;
				$scope.putMessage = response.data;
			}, function error(response) {
				$scope.error = true;
				$scope.putMessage = "Error!";
			});
		}
		/* $rootScope.isLoading = false; */
	}

	// using http Delete to delete the hospital info
	$scope.deleteHospital = function() {
		if ($scope.selectedHospital) {
			// put URL
			var url = 'http://localhost:8080/test/deleteHospital/'
					+ $scope.selectedHospital.id;

			$http['delete'](url);

		}
	}

});