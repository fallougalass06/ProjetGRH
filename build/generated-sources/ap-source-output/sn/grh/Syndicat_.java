package sn.grh;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Membresyndicat;
import sn.grh.Syndicattypeemploye;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T11:51:15")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T09:40:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T10:00:41")
>>>>>>> ff529762cddd21f09cc44ec13340571022b471f6
>>>>>>> ddba5288e695677d076de01e62bb52b19b3f4e84
@StaticMetamodel(Syndicat.class)
public class Syndicat_ { 

    public static volatile SingularAttribute<Syndicat, String> code;
    public static volatile ListAttribute<Syndicat, Membresyndicat> membresyndicatList;
    public static volatile ListAttribute<Syndicat, Syndicattypeemploye> syndicattypeemployeList;
    public static volatile SingularAttribute<Syndicat, Integer> id;
    public static volatile SingularAttribute<Syndicat, String> nomSyndicat;

}