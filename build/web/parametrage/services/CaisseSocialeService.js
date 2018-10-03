/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('ParametrageModule').factory('CaisseSociale', function ($http) {
    return{

        findAll: function () {
            return $http.get(chemin + '/webresources/sn.grh.caissesociale');
        },
        find: function (id) {
            return $http.get(chemin + '/webresources/sn.grh.caissesociale/' + id);
        },
        findByLibelle: function (lib) {
            return $http.get(chemin + '/webresources/sn.grh.caissesociale/libelle/' + lib);
        },
        add: function (item) {
            return $http.post(chemin + '/webresources/sn.grh.caissesociale', item);
        },

        delete: function (id) {
            return $http.delete(chemin + '/webresources/sn.grh.caissesociale/' + id);
        },

        edit: function (item) {
            return $http.put(chemin + '/webresources/sn.grh.caissesociale/' + item.id, item);
        }
    };
});

