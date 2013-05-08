/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import Datentypen.TransportAuftragTyp;

/**
 *
 * @author Barzgun
 */
public interface IVersandFassade {

    public LieferungTyp erstelleLieferung(AuftragTyp auftrag);

    public TransportAuftragTyp erstelleTransportAuftrag(LieferungTyp lieferung);
}
