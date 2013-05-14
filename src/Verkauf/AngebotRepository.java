package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import Exceptions.SQLException;
import Main.HibernateUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class AngebotRepository {

    private Exception SQLException;

    public Angebot erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe, Double gesamtKosten) throws Exception {
        Angebot angebot = new Angebot(kunde, gueltigBis, produktListe, gesamtKosten);
        if (angebot == null) {
            throw SQLException;
        }

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(angebot);
        session.getTransaction().commit();

        return angebot;
    }

    public List<Angebot> getAngebote(String kunde) {
        //   List<Angebot> angebotListe = null;

        Session session = HibernateUtil.getSession();
        List<Angebot> angebote = session
                .createQuery("FROM Angebot angebot WHERE kunde = :kunde")
                .setParameter("kunde", kunde).list();

        //get alle Angebot anhand KundenName
        return angebote;
    }

    public Angebot getAngebot(String angebotsNr) {
        //  Angebot angebot = null;

        Session session = HibernateUtil.getSession();
        List<Angebot> angebote = session
                .createQuery("FROM Angebot angebot WHERE angebotsNr = :angebotsNr")
                .setParameter("angebotsNr", angebotsNr).list();

        Angebot angebot = null;
        if (!angebote.isEmpty()) {
            angebot = angebote.get(0);
        }

        //   return rechnung;
        // get angebot from DatenBank anhand KundenNr
        return angebot;
    }
}
