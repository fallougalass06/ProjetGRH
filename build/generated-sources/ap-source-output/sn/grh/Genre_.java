package sn.grh;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Civilite;
import sn.grh.Employe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-27T09:32:34")
@StaticMetamodel(Genre.class)
public class Genre_ { 

    public static volatile ListAttribute<Genre, Employe> employeList;
    public static volatile SingularAttribute<Genre, String> libelle;
    public static volatile SingularAttribute<Genre, Integer> id;
    public static volatile ListAttribute<Genre, Civilite> civiliteList;

}