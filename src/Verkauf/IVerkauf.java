package Verkauf;

import java.util.*;

import Datentypen.*;
import Exceptions.KundeException;

/**
 *
 * @author NED
 */
public interface IVerkauf {
    
    public KundenTyp getKunde(String kundeNr)throws KundeException;
    
    public KundenTyp getKunde(String vorname,String nachname,AdresseTyp adresse)throws KundeException;
    
    public KundenTyp getKunde(TelefonNrTyp tel)throws KundeException;
    
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp dresse, TelefonNrTyp telefon)throws KundeException;

    public ProduktTyp fordereProduktInformationen(String produktNummer);

    public AngebotTyp erstelleAngebot (KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe);

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot);
    
    public List<AngebotTyp> getAngebot(String kundenName);
    
    public List<AuftragTyp> getAuftrag(String kundenName);

    public AngebotTyp getAngebotPerAngebotNr(String angebotNr);
    
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr);
    
    

}
