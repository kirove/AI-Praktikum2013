package Verkauf;

import java.util.*;

import Datentypen.*;

/**
 *
 * @author NED
 */
public interface IVerkauf {
    
    public KundenTyp getKunde(String kundeNr);
    
    public KundenTyp getKunde(String vorname,String nachname,AdresseTyp adresse);
    
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp dresse, TelefonNrTyp telefon);

    public ProduktTyp fordereProduktInformationen(int produktNummer);

    public AngebotTyp erstelleAngebot (KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe);

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot);
    
    public List<AngebotTyp> getAngebot(String kundenName);
    
    public List<AuftragTyp> getAuftrag(String kundenName);

    public AngebotTyp getAngebotPerAngebotNr(String angebotNr);
    
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr);
    
    

}
