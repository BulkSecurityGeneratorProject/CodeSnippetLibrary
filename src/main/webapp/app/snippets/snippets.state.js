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
        $stateProvider.state('snippets', {
            parent: 'app',
            url: '/snippets/:username',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Snippets'
            },
            views: {
                'content@': {
                    templateUrl: 'app/snippets/user/snippets.html',
                    controller: 'SnippetsController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
