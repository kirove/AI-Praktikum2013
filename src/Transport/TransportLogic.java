/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import Datentypen.TransportAuftragTyp;

/**
 *
 * @author Barzgun
 */
public class TransportLogic {

    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
      return  TransportRepository.erstelleLieferung(auftrag).getTyp();
    }

    public boolean getLieferungStatus(LieferungTyp lieferung) {
        return lieferung.isLieferungErfolgt();
    }
    
    public TransportAuftragTyp erstelleTransportAuftrag(LieferungTyp lieferung){
        return TransportRepository.erstelleTransportAuftrag(lieferung).getTyp();
    }
}
