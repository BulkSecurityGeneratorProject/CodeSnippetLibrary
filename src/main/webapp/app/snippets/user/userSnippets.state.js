/**
 * Created by smyrgeorge on 28/6/2016.
 */
(function() {
    'use strict';

    angular
        .module('codeSnippetLibraryApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('user-snippets', {
            parent: 'app',
            url: '/snippets/:username',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'User Snippets'
            },
            views: {
                'content@': {
                    templateUrl: 'app/snippets/user/user_snippets.html',
                    controller: 'UserSnippetsController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
