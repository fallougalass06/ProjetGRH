package sn.grh;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Civilite;
import sn.grh.Employe;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-02T12:59:19")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-30T12:14:09")
>>>>>>> b25d4eb239b8d427ca95fe33e414e7c2254ea3a6
@StaticMetamodel(Genre.class)
public class Genre_ { 

    public static volatile ListAttribute<Genre, Employe> employeList;
    public static volatile SingularAttribute<Genre, String> libelle;
    public static volatile SingularAttribute<Genre, Integer> id;
    public static volatile ListAttribute<Genre, Civilite> civiliteList;

}