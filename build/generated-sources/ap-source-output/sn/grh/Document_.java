package sn.grh;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.grh.Absence;
import sn.grh.Avoircompetence;
import sn.grh.Employe;
import sn.grh.Formation;
import sn.grh.Typedocument;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-02T12:59:19")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-30T12:14:09")
>>>>>>> b25d4eb239b8d427ca95fe33e414e7c2254ea3a6
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> emplacement;
    public static volatile SingularAttribute<Document, Avoircompetence> avoirCompetence;
    public static volatile SingularAttribute<Document, Date> dateSignature;
    public static volatile SingularAttribute<Document, Boolean> situationMatrimoniale;
    public static volatile SingularAttribute<Document, Employe> employe;
    public static volatile SingularAttribute<Document, Absence> absence;
    public static volatile SingularAttribute<Document, String> description;
    public static volatile SingularAttribute<Document, Typedocument> typeDocument;
    public static volatile SingularAttribute<Document, Formation> formation;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, Date> dateEnregistrement;
    public static volatile SingularAttribute<Document, Date> echeance;

}