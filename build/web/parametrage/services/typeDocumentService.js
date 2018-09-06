/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('ParametrageModule').factory('Typedocument', function ($http) {
    return{

        findAll: function () {
            return $http.get(chemin + '/webresources/sn.grh.typedocument');
        },
        find: function (id) {
            return $http.get(chemin + '/webresources/sn.grh.typedocument/' + id);
        },

        add: function (item) {

            return $http.post(chemin + '/webresources/sn.grh.typedocument', item);
        },

        delete: function (id) {
            return $http.delete(chemin + '/webresources/sn.grh.typedocument/' + id);
        },

        edit: function (item) {
            return $http.put(chemin + '/webresources/sn.grh.typedocument/' + item.id, item);
        }
    };
});




