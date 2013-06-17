/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
//import Datentypen.TransportAuftragTyp;

/**
 *
 * @author Barzgun
 */
public class VersandFassade implements IVersandFassade{

    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        return LieferungRepository.erstelleLieferung(auftrag).getTyp();
    }

   
}
