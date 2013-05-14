package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp;
import java.util.ArrayList;
import java.util.List;
import Lager.ILagerFassade;
import Lager.LagerFassade;
import Lager.LagerLogic;
import Versand.IVersandFassade;
import Rechnung.IRechnungFassade;
import Rechnung.RechnungLogic;
import Versand.VersandFassade;
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
    IVersandFassade VF;
    IRechnungFassade RF;

    public AuftragLogic() {
        this.AR = new AuftragRepository();
        this.LF = new LagerFassade();
        this.VF = new VersandFassade();
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
            AuftragTyp auftrag = this.AR.createAuftrag(angebot).getTyp();
            if (LF.produktReservieren(auftrag) != null) {

                this.VF.erstelleLieferung(auftrag);
            }
            try {
                this.RF.erstelleRechnung(angebot.getPreis(), auftrag.getAuftragsNr(), new Date(), angebot.getKunde().getKundenNr());
            } catch (Exception ex) {
                
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

    @Override
    public void schliesseBezahlteAuftraege() {
        List<AuftragTyp> nichtAbgeschlosseneAuftraege = getNichtAbgeschlosseneAuftraege();
        for (int i = 0; i < nichtAbgeschlosseneAuftraege.size(); i++) {
            try {
                RechnungTyp rechnung = this.RF.getRechnungPerAuftragNr(nichtAbgeschlosseneAuftraege.get(i).getAuftragsNr());

                if (rechnung.IsBezahlt()) {
                    this.schliesseAuftrag(nichtAbgeschlosseneAuftraege.get(i));
                }
            } catch (Exception ex) {
                Logger.getLogger(VerkaufFassade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
