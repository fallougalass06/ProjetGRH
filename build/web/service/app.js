angular.module("ServiceModule",['ngRoute','ngMessages']).config(function ($routeProvider){
    $routeProvider.when('/service/:id',{
        templateUrl: 'service/entite/detailentite.html',
        controller: 'DetailEntiteController'
    }).when('/service/consulter/:id',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeEntiteController'
        
    }).when('/service/consulter/:id/type/:type',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeEntiteController'
        
    }).when('/service/consulter/:id/homme/type/:type',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeHommeEntiteController'
        
    }).when('/service/consulter/:id/homme',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeHommeEntiteController'
        
    }).when('/service/consulter/:id/femme/type/:type',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeFemmeEntiteController'
        
    }).when('/service/consulter/:id/femme',{
        templateUrl: 'drh/employe/consulterAgent.html',
        controller: 'ConsulterEmployeFemmeEntiteController'
        
    }).when('/service/demandes/absence',{
        templateUrl: 'drh/demandes/listeAbsence.html',
        controller: 'ListeAbsenceController'
        }).when('/service/demandes/conge',{
        templateUrl: 'drh/demandes/listeConge.html',
        controller: 'ListeCongeController'
     }).when('/service/demandes/detailConge',{
        templateUrl: 'drh/demandes/detailConge.html',
        controller: 'DetailCongeController'
      }).when('/service/demandes/detailAbsence',{
        templateUrl: 'drh/demandes/detailAbsence.html',
        controller: 'DetailAbsenceController'
    }).otherwise('/');
});


