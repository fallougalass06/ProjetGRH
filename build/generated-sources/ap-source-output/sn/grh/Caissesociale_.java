package sn.grh;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Caissesocialetypeemploye;
import sn.grh.Employe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-01T09:14:27")
@StaticMetamodel(Caissesociale.class)
public class Caissesociale_ { 

    public static volatile SingularAttribute<Caissesociale, String> code;
    public static volatile ListAttribute<Caissesociale, Employe> employeList;
    public static volatile ListAttribute<Caissesociale, Caissesocialetypeemploye> caissesocialetypeemployeList;
    public static volatile SingularAttribute<Caissesociale, String> libelle;
    public static volatile SingularAttribute<Caissesociale, Integer> id;

}