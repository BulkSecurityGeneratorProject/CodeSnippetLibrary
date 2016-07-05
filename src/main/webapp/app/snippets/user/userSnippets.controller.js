/**
 * Created by smyrgeorge on 28/6/2016.
 */
(function() {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .controller('UserSnippetsController', UserSnippetsController);

    UserSnippetsController.$inject = ['$stateParams', 'UserSnippetsService'];

    function UserSnippetsController ($stateParams, UserSnippetsService) {
        var vm = this;

        vm.query = '';
        vm.data = {}
        vm.username = $stateParams.username;
        vm.showResults = false

        vm.search = search;

        vm.search();

        function search() {
            if (vm.query !== '') {
                vm.showResults = true;
            } else {
                vm.showResults = false;
                UserSnippetsService.findAll().then(function(val) {
                    vm.data = val;
                    console.log(vm.data[0])
                });
            }
        }
    }
})();
