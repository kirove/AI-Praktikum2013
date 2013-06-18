/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import ReSTAdaptor.ITransportAuftrag;
import ReSTAdaptor.Verwalter.TDLAdapter;

/**
 *
 * @author Barzgun
 */
public class LieferungLogic implements IVersandFassade {

    LieferungRepository LR;
    Transportauftrag transportAuftrag;
    ITransportAuftrag tdla;

    public LieferungLogic() {
        this.LR = new LieferungRepository();
        this.tdla = new TDLAdapter();
    }

    public LieferungTyp erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        //save in DB
        LieferungTyp lieferungTyp = LR.erstelleLieferung(lieferung).getTyp();



        transportAuftrag = new Transportauftrag(lieferungTyp);


        tdla.sendeTransportAuftrag(transportAuftrag.getTyp());

        return lieferungTyp;
    }

    public boolean getLieferungStatus(LieferungTyp lieferung) {
        return lieferung.isLieferungErfolgt();
    }
}
