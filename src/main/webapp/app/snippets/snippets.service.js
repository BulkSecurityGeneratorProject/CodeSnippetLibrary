/**
 * Created by smyrgeorge on 28/6/2016.
 */
(function() {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .factory('SnippetsService', SnippetsService);

    SnippetsService.$inject = ['$http'];

    function SnippetsService ($http) {

        var service = {
            findAll: findAll
        };

        return service;


        function findAll (username) {
            return $http.get('/api/snippets/' + username).then(function (response) {
                return response.data;
            });
        }
    }
})();
