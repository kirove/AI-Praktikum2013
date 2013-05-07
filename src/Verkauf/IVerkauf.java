package Verkauf;

import java.util.*;
import Lager.IProdukt;
import Kunde.IKunde;
import Lager.ILager;

/**
 *
 * @author NED
 */
public interface IVerkauf {
    
    public IKunde getKunde(String kundeNr);
    
    public IKunde getKunde(String vorname,String nachname);
    
    public IKunde erstelleKunde(String vorName, String nachName, String adresse);

    public ILager fordereProduktInformationen(int produktNummer);

    public IAngebot erstelleAngebot (String kundenName, Date gueltigBis, Map<String, Integer> produktListe);

    public IAuftrag erstelleAuftrag(IAngebot angebot);
    
    public List<IAngebot> getAngebot(String kundenName);
    
    public List<IAuftrag> getAuftrag(String kundenName);

}