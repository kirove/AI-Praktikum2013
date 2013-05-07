package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import java.util.ArrayList;
import java.util.List;
import Lager.ILagerFassade;
import Lager.LagerLogic;
import Transport.TransportLogic;
import Rechnung.IRechnungFassade;
import Rechnung.RechnungLogic;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class AuftragLogic implements IAuftragManager {

    AuftragRepository AR;
    ILagerFassade LF;
    TransportLogic TL;
    IRechnungFassade RF;

    public AuftragLogic() {
        this.AR = new AuftragRepository();
        this.LF = new LagerLogic();
        this.TL = new TransportLogic();
        this.RF = new RechnungLogic();
    }

    @Override
    public List<AuftragTyp> sucheAuftrage(String kundenName) {
        List<AuftragTyp> auftragListe = new ArrayList<>();
        List<Auftrag> aListe = this.AR.getAuftrage(kundenName);

        for (int i = 0; i < aListe.size(); i++) {
            auftragListe.add(aListe.get(i).getTyp());
        }

        return auftragListe;
    }

    @Override
    public AuftragTyp sucheAuftragePerNr(String auftragNr) {
        return this.AR.getAuftragPerNr(auftragNr).getTyp();
    }

    @Override
    public AuftragTyp schliesseAuftrag(AuftragTyp auftragTyp) {
        Auftrag auftrag = this.AR.getAuftragPerNr(auftragTyp.getAuftragsNr());
        auftrag.setIsAbgeschlossen(true);

        return this.AR.updateAuftrag(auftrag).getTyp();
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        if (istLagerbestandAusreichend(angebot)) {
            LF.produktReservieren(angebot);
            AuftragTyp auftrag = this.AR.createAuftrag(angebot).getTyp();

            this.TL.erstelleLieferung(auftrag);

            try {
                this.RF.erstelleRechnung(angebot.getPreis(), auftrag.getAuftragsNr(), new Date(), angebot.getKunde().getKundenNr());
            } catch (Exception ex) {
                Logger.getLogger(AuftragLogic.class.getName()).log(Level.SEVERE, null, ex);
            }

            return auftrag;
        } else {
            return null;
        }
    }

    public boolean istLagerbestandAusreichend(AngebotTyp angebot) {
        return LF.isLagerbestandAusreichend(angebot);
    }

    public List<AuftragTyp> getNichtAbgeschlosseneAuftraege() {
        boolean istAbgeschlossen = false;
        List<AuftragTyp> nichtAbgeschlosseneAuftraegeListe = new ArrayList<>();
        List<Auftrag> aListe = this.AR.getAuftrag(istAbgeschlossen);

        for (int i = 0; i < aListe.size(); i++) {
            nichtAbgeschlosseneAuftraegeListe.add(aListe.get(i).getTyp());
        }

        return nichtAbgeschlosseneAuftraegeListe;
    }
}
