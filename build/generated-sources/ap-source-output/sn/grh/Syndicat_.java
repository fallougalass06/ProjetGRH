package sn.grh;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Membresyndicat;
import sn.grh.Syndicattypeemploye;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T09:40:39")
@StaticMetamodel(Syndicat.class)
public class Syndicat_ { 

    public static volatile SingularAttribute<Syndicat, String> code;
    public static volatile ListAttribute<Syndicat, Membresyndicat> membresyndicatList;
    public static volatile ListAttribute<Syndicat, Syndicattypeemploye> syndicattypeemployeList;
    public static volatile SingularAttribute<Syndicat, Integer> id;
    public static volatile SingularAttribute<Syndicat, String> nomSyndicat;

}