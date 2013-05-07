
package Verkauf;

import Kunde.IKundeManager;
import Lager.ILagerManager;

import Lieferant.ILieferantManager;

import Rechnung.IRechnungManager;

import Lager.ILagerRepository;
import Lager.ILagerFassade;

import java.util.*;




/**
 *
 * @author NED
 */
public class VerkaufFassade implements IVerkauf{

    @Override
    public IKunde getKunde(String kundeNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IKunde getKunde(String vorname, String nachname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IKunde erstelleKunde(String vorName, String nachName, String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILagerManager fordereProduktInformationen(int produktNummer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAngebot erstelleAngebot(String kundenName, Date gueltigBis, Map<String, Integer> produktListe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAuftrag erstelleAuftrag(IAngebot angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IAngebot> getAngebot(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IAuftrag> getAuftrag(String kundenName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
