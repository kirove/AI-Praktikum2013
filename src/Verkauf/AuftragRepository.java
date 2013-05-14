package Verkauf;

import Datentypen.AngebotTyp;
import Main.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NED
 */
public class AuftragRepository {

    public Auftrag createAuftrag(AngebotTyp angebot) {

        Auftrag newAuftrag = new Auftrag(angebot);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newAuftrag);
        session.getTransaction().commit();

        return newAuftrag;
    }

    public Auftrag getAuftragPerNr(String auftragsNr) {

        Session session = HibernateUtil.getSession();
        List<Auftrag> auftraege = session
                .createQuery("FROM Auftrag auftrag WHERE auftragsNr = :auftragsNr")
                .setParameter("auftragsNr", auftragsNr).list();

        Auftrag auftrag = null;
        if (!auftraege.isEmpty()) {
            auftrag = auftraege.get(0);
        }

        return auftrag;
    }

    public List<Auftrag> getAuftrage(String kunde) {
        Session session = HibernateUtil.getSession();
        List<Angebot> angebote = session
                .createQuery("FROM Angebot angebot WHERE kunde = :kunde")
                .setParameter("kunde", kunde).list();
        List<Auftrag> auftraege = null;
        for (Angebot angebot : angebote) {
            List<Auftrag> auftraegen = session
                    .createQuery("FROM Auftrag auftrag WHERE angebot = :angebot")
                    .setParameter("angebot", angebot).list();
            auftraege.addAll(auftraegen);
        }

        return auftraege;

    }

    public Auftrag updateAuftrag(Auftrag auftrag) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.saveOrUpdate(auftrag);
            // Committing the change in the database.
            session.flush();
            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return auftrag;
    }

    public List<Auftrag> getAuftrag(boolean isAbgeschlossen) {
        Session session = HibernateUtil.getSession();
        List<Auftrag> auftraege = session
                .createQuery("FROM Auftrag auftrag WHERE isAbgeschlossen = :isAbgeschlossen")
                .setParameter("isAbgeschlossen", isAbgeschlossen).list();

        //get alle aufträge die noch nicht abgeschlossen sind
        return auftraege;
    }
}
