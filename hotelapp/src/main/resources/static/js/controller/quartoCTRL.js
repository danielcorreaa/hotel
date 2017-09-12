angular.module('hotelapp', []).controller("quartoCTRL",
		function($scope, $http) {
			$scope.quarto = {};
			var carregarQuartos = function() {
				$http.get("http://localhost:8082/quartos").then(function(response) {
					$scope.quartos = response.data;					
				});				
			};
			
			$scope.save = function(quarto) {
				console.log(quarto);
				$http.post("http://localhost:8082/quartos", quarto).then(function(response) {
					delete $scope.quarto;
					carregarQuartos();
				});
			};
			
			$scope.excluir = function(porta) {
				console.log(porta);
				$http.delete("http://localhost:8082/quartos/"+porta).then(function(response) {
					
					carregarQuartos();
				});
			};
			
			$scope.alterar = function(quarto) {
				console.log(quarto);
				$scope.quarto = quarto;
			};
			
			carregarQuartos();
		});