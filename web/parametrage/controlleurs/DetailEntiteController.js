/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('ParametrageModule').controller('DetailEntiteController', function ($scope, Servir, Securite, SweetAlert, Entite, TypeEntite, $routeParams) {

    /*  Verifier que l'utilisateur est connecte:controles supplementaire     */


    if (Securite.estConnecte() == false) {
        document.location.href = "#/";
        return;
    }


    /*  Verifier que l'utilisateur est connecte:controles supplementaire =>fin     */

    $scope.entites = [];
    $scope.entite = {id: ""};

    Entite.find($routeParams.id).success(function (data) {
        $scope.entite = data;
        $scope.trouverResponsable($scope.entite);

        Entite.findAll().success(function (data) {
            $scope.entites = data;
            for (var i = 0; i < $scope.entites.length; i++) {
                if ($scope.entite.entite && $scope.entites[i].id == $scope.entite.entite.id) {
                    $scope.selectedEntite = $scope.entites[i];
                    break;
                }
            }
        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Erreur lors de la r�cup�ration des entit�s");
        });

        TypeEntite.findAll().success(function (data) {
            $scope.typeentites = data;
            for (var i = 0; i < $scope.typeentites.length; i++) {

                if ($scope.typeentites[i].id == $scope.entite.typeEntite.id) {
                    $scope.selectedTypeEntite = $scope.typeentites[i];
                    break;
                }
            }
        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Erreur lors de la r�cup�ration des types d'entit�");
        });

    }).error(function () {
        SweetAlert.simpleNotification("error", "Erreur", "Erreur lors de la r�cup�ration des informations sur l'entit�");
    });


    $scope.trouverResponsable = function (e) {
        Servir.findResponsableEntite(e).success(function (data) {
            $scope.responsable = "non défini";
            if (data != null) {
                $scope.responsable = data.employe.prenom + " " + data.employe.nom;
            }

        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Erreur lors de la r�cup�ration du responsable");
        });
    };


    $scope.controlForm = function (c) {
        if (c.nom == null || c.nom == "") {
            $("div.requis").eq(0).show("slow").delay(3000).hide("slow");
        } else {
            if (c.adresse == null || c.adresse == "") {
                $("div.requis").eq(1).show("slow").delay(3000).hide("slow");
            } else {
                if (c.telephone == null || c.telephone == "") {
                    $("div.requis").eq(2).show("slow").delay(3000).hide("slow");
                } else {
                    if (c.email == null || c.email == "") {
                        $("div.requis").eq(3).show("slow").delay(3000).hide("slow");
                    } else {
                        if (c.typeEntite == null) {
                            $("div.requis").eq(4).show("slow").delay(3000).hide("slow");
                        } else {
                            $scope.edit(c);
                        }

                    }
                }
            }
        }

    };

    $scope.edit = function (item) {

        item.entite = $scope.selectedEntite;
        item.typeEntite = $scope.selectedTypeEntite;

        SweetAlert.attendreTraitement("Traitement en cours", "Veuillez patienter svp !");
        Entite.edit(item).success(function () {
            SweetAlert.simpleNotification("success", "Succes", "Modification effectu�e avec succes");
            document.location.href = '#/parametrage/entite/show';
        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Echec de la modification");
        });
    };

});

