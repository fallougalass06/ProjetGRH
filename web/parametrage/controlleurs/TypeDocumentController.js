/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('ParametrageModule').controller('TypeDocumentController', function ($scope, Securite, SweetAlert, Typedocument) {

    /*  Verifier que l'utilisateur est connecte:controles supplementaire     */


    if (Securite.estConnecte() == false) {
        document.location.href = "#/";
        return;
    }


    /*  Verifier que l'utilisateur est connecte:controles supplementaire =>fin     */

    $scope.typedocuments = [];
    $scope.typedocument = {id: ""};

    $scope.editForm = false;
    $scope.createForm = true;

    $scope.toggle = function () {
        $scope.editForm = !$scope.editForm;
        $scope.createForm = !$scope.createForm;
    };


    $scope.controlForm = function (c) {
        if (c.code == null || c.code == "") {
            $("div.requis").eq(0).show("slow").delay(3000).hide("slow");
        } else {
            if (c.dureeArchivage == null || c.dureeArchivage == "") {
                $("div.requis").eq(1).show("slow").delay(3000).hide("slow");
            } else {
                if ($scope.createForm == true) {
                    $scope.add(c);
                } else {
                    $scope.edit(c);
                }
            }
        }
    };

    $scope.add = function (s) {
        SweetAlert.attendreTraitement("Traitement en cours", "Veuillez patienter svp !");
        Typedocument.add(s).success(function () {
            SweetAlert.simpleNotification("success", "Succes", "Type de document ajout� avec succes");
            $scope.findAll();
            $scope.typedocument = {id: ""};
        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Le type de document n'a pas pu etre ajout�");
        });
    };

    $scope.findAll = function () {
        Typedocument.findAll().success(function (data) {
            SweetAlert.finirChargementSucces("Chargement complet !");
            $scope.typedocuments = data;
        }).error(function () {
            SweetAlert.finirChargementEchec("Erreur de chargement des types de document !");
        });
    };

    $scope.findAll();

    $scope.edit = function (item) {
        SweetAlert.attendreTraitement("Traitement en cours", "Veuillez patienter svp !");
        Typedocument.edit(item).success(function () {
            SweetAlert.simpleNotification("success", "Succes", "Modification effectu�e avec succes");
            $scope.findAll();
            $scope.typedocument = {id: ""};
            $scope.toggle();
        }).error(function () {
            SweetAlert.simpleNotification("error", "Erreur", "Echec de la modification");
        });
    };
    $scope.findAll();

    $scope.setCurrent = function (typedocument) {
        $scope.typedocument = typedocument;
        $('.edit').attr('disabled', 'disabled');
        $scope.toggle();
    };
    $scope.annuler = function () {

        $('.btn').removeAttr('disabled');
        $('form').trigger("reset");
        $scope.toggle();
    };
    $scope.delete = function (item) {

        bootbox.confirm({
            title: "Suppression !",
            message: "Voulez vous supprimer l'élement",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Annuler'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirmer'
                }
            },
            callback: function (result) {
                if (result == true) {
                    var dialog = bootbox.dialog({
                        title: 'SUPPRESSION',
                        message: '<p><i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i><span>Suppression ...</span></p>'
                    });
                    Typedocument.delete(item.id).success(function () {
                        dialog.modal('hide');
                        $scope.findAll();
                    }).error(function () {
                        dialog.find('.bootbox-body').html('<div class="alert alert-block alert-error"><i class="fa fa-3x fa-check" aria-hidden="true"></i>Une erreur est survenue</div>');
                    });
                }
            }
        });


    };


});

