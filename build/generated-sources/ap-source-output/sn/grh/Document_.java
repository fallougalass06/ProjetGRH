package sn.grh;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Absence;
import sn.grh.Avoircompetence;
import sn.grh.Conjoint;
import sn.grh.Employe;
import sn.grh.Enfant;
import sn.grh.Formation;
import sn.grh.Historiquegrade;
import sn.grh.Membremutuelle;
import sn.grh.Servir;
import sn.grh.Typedocument;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T17:50:52")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-07T10:54:18")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-07T12:32:09")
>>>>>>> 4b4c1760fbced970b7ab4e104c492f64037af156
>>>>>>> 920c05e4a816cd3bc4916740ecf205a7a58e1ea0
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> emplacement;
    public static volatile SingularAttribute<Document, Avoircompetence> avoirCompetence;
    public static volatile SingularAttribute<Document, Historiquegrade> historiqueGrade;
    public static volatile SingularAttribute<Document, Date> dateSignature;
    public static volatile SingularAttribute<Document, Boolean> situationMatrimoniale;
    public static volatile SingularAttribute<Document, Membremutuelle> membreMutuelle;
    public static volatile SingularAttribute<Document, Employe> employe;
    public static volatile SingularAttribute<Document, Absence> absence;
    public static volatile SingularAttribute<Document, String> description;
    public static volatile SingularAttribute<Document, Boolean> syndicat;
    public static volatile SingularAttribute<Document, Formation> formation;
    public static volatile SingularAttribute<Document, Date> dateEnregistrement;
    public static volatile SingularAttribute<Document, Conjoint> conjoint;
    public static volatile SingularAttribute<Document, Boolean> caisseSociale;
    public static volatile SingularAttribute<Document, Typedocument> typeDocument;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, Enfant> enfant;
    public static volatile SingularAttribute<Document, Servir> servir;
    public static volatile SingularAttribute<Document, Date> echeance;

}