
package Verkauf;

import Datentypen.*;
import Kunde.IKundeManager;
import Lager.ILager;

import Lieferant.ILieferantManager;

import Rechnung.IRechnungManager;

import Lager.ILagerManager;

import java.util.*;




/**
 *
 * @author NED
 */
public class VerkaufFassade implements IVerkauf{

    IKundeManager KM;
    ILagerManager LM; 
    @Override
    public KundenTyp getKunde(String kundeNr) {
        return KM.getKunde(kundeNr);
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) {
        return KM.getKunde(vorname, nachname,adresse );
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, String adresse, TelefonNrTyp telefon) {
        return KM.erstelleKunde(vorName, nachName, adresse, telefon);
    }

    @Override
    public ProduktTyp fordereProduktInformationen(int produktNummer) {
        
    }

    @Override
    public AngebotTyp erstelleAngebot(String kundenName, Date gueltigBis, Map<String, Integer> produktListe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAuftrag erstelleAuftrag(AngebotTyp angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AngebotTyp> getAngebot(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IAuftrag> getAuftrag(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, String adresse, TelefonNrTyp telefon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AngebotTyp> getAngebot(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AuftragTyp> getAuftrag(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AngebotTyp getAngebotPerAngebotNr(String angebotNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
