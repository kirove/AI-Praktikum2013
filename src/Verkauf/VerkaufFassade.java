package Verkauf;

import Datentypen.*;
import Kunde.KundeLogic;
import Lager.ILagerEvents;

import Lieferant.ILieferantManager;

import Rechnung.IRechnungManager;

import Lager.ILagerManager;
import Lager.IProduktManager;


import java.util.*;

/**
 *
 * @author NED
 */
public class VerkaufFassade implements IVerkauf {

    private KundeLogic KM;
    private IProduktManager PM;
    private ILagerEvents LE;
    private IAuftragManager AufM;
    private IAngebotManager AngM;

    @Override
    public KundenTyp getKunde(String kundeNr) {
        return KM.getKunde(kundeNr);
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) {
        return KM.getKunde(vorname, nachname, adresse);
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) {
        return KM.erstelleKunde(vorName, nachName, adresse, telefon);
    }

    @Override
    public ProduktTyp fordereProduktInformationen(int produktNummer) {
        return PM.fordereProduktInformationen(produktNummer);
    }

    @Override
    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe) {
        return AngM.erstelleAngebot(kunde, gueltigBis, produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        return AufM.erstelleAuftrag(angebot);
    }

    @Override
    public List<AngebotTyp> getAngebot(String kundenName) {
        return AngM.sucheAngebote(kundenName);
    }

    @Override
    public List<AuftragTyp> getAuftrag(String kundenName) {
        return AufM.sucheAuftrage(kundenName);
    }

    @Override
    public AngebotTyp getAngebotPerAngebotNr(String angebotNr) {
        return AngM.sucheAngebotePerNr(angebotNr);
    }

    @Override
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr) {
        return AufM.sucheAuftragePerNr(auftragNr);
    }
}
