/**
 * Created by smyrgeorge on 28/6/2016.
 */
(function() {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .factory('UserSnippetsService', UserSnippetsService);

    UserSnippetsService.$inject = ['$http'];

    function UserSnippetsService ($http) {

        var service = {
            findAll: findAll
        };

        return service;


        function findAll () {
            return $http.get('/api/user_snippets').then(function (response) {
                return response.data;
            });
        }
    }
})();
