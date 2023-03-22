angular.module('application', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app';

    $scope.fillProductsTable = function () {
        $http.get(contextPath + '/all')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.addProduct = function () {
        if (confirm("Do you want to add product «" + document.getElementsByName("titleNew")[0].value +
            "» with cost " + document.getElementsByName("costNew")[0].value + "?")) {
            $http({
                url: contextPath + '/add',
                method: 'post',
                params: {
                    title: document.getElementsByName("titleNew")[0].value,
                    cost: document.getElementsByName("costNew")[0].value
                }
            }).then(function () {
                $scope.fillProductsTable();
                $('#addProduct')[0].reset();
                alert("Added");
            });
        } else {
            alert("Canceled");
        }
    }

    $scope.deleteProductById = function (productId, productTitle, productCost) {
        if (confirm("Do you want to delete product «" + productTitle + "» with ID=" + productId + " and Cost=" + productCost + "?")) {
            $http.get(contextPath + '/delete/' + productId)
                .then(function () {
                    $scope.fillProductsTable();
                    alert("Deleted");
                });
        } else {
            alert("Canceled");
        }
    }

    $scope.findProduct = function () {
        if (confirm("Do you want to find product with ID=" + document.getElementsByName("finderId")[0].value + "?")) {
            $http.get(contextPath + '/product/' + document.getElementsByName("finderId")[0].value)
                .then(function (response) {
                    if (response.data.length &&response.data[0] === null) {
                        alert("No product with ID=" + document.getElementsByName("finderId")[0].value)
                        $scope.fillProductsTable();
                        document.getElementsByName("finderId").value = ''
                    } else {
                        alert("Found");
                        document.getElementsByName("finderId")[0].value = "";
                        $scope.ProductsList = response.data;
                    }
                });
        } else {
            alert("Canceled");
        }
    }

    $scope.fillProductsTable();
})