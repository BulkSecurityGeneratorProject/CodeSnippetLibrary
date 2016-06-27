(function () {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
