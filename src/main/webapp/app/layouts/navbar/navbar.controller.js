(function() {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$rootScope', '$state', 'Auth', 'Principal', 'ProfileService', 'LoginService'];

    function NavbarController ($rootScope, $state, Auth, Principal, ProfileService, LoginService) {
        var vm = this;

        vm.account = null;
        vm.isNavbarCollapsed = true;
        vm.isAuthenticated = Principal.isAuthenticated;

        ProfileService.getProfileInfo().then(function(response) {
            vm.inProduction = response.inProduction;
            vm.swaggerDisabled = response.swaggerDisabled;
        });

        vm.login = login;
        vm.logout = logout;
        vm.toggleNavbar = toggleNavbar;
        vm.collapseNavbar = collapseNavbar;
        vm.snippets = snippets;
        vm.$state = $state;

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }

        function login() {
            collapseNavbar();
            LoginService.open();
        }

        function logout() {
            collapseNavbar();
            Auth.logout();
            $state.go('home');
        }

        function toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }

        function collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }

        function snippets() {
            if (vm.account === null) {
                Principal.identity().then(function(account) {
                    $state.go('snippets', {'username': account.login});
                });
            } else {
                $state.go('snippets', {'username': vm.account.login});
            }
        }
    }
})();
