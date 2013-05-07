/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import java.util.Date;

/**
 *
 * @author Barzgun
 */
public class TransportRepository {
    public static Lieferung erstelleLieferung(AuftragTyp auftrag){
      Lieferung lieferung = new Lieferung(auftrag);
        return lieferung;
    }
    public static TransportAuftrag erstelleTransportAuftrag(LieferungTyp lieferung){
        return new TransportAuftrag(new Date(), lieferung);
    }
}
