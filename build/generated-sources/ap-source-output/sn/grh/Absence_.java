package sn.grh;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Document;
import sn.grh.Employe;
import sn.grh.Typeabsence;
import sn.grh.Typeautorisation;
import sn.grh.Typepermission;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T11:51:15")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T09:40:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-25T10:00:41")
>>>>>>> ff529762cddd21f09cc44ec13340571022b471f6
>>>>>>> ddba5288e695677d076de01e62bb52b19b3f4e84
@StaticMetamodel(Absence.class)
public class Absence_ { 

    public static volatile SingularAttribute<Absence, Integer> etatTraitement;
    public static volatile SingularAttribute<Absence, Employe> employe;
    public static volatile SingularAttribute<Absence, Integer> jourRestant;
    public static volatile SingularAttribute<Absence, Date> dateEnregistrement;
    public static volatile SingularAttribute<Absence, Typeabsence> typeAbsence;
    public static volatile SingularAttribute<Absence, Date> dateDebut;
    public static volatile ListAttribute<Absence, Document> documentList;
    public static volatile SingularAttribute<Absence, Typeautorisation> typeAutorisation;
    public static volatile SingularAttribute<Absence, Integer> duree;
    public static volatile SingularAttribute<Absence, Integer> id;
    public static volatile SingularAttribute<Absence, Date> dateFin;
    public static volatile SingularAttribute<Absence, String> motif;
    public static volatile SingularAttribute<Absence, Typepermission> typePermission;

}