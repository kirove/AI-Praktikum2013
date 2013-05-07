/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import Datentypen.*;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IAuftragManager {

    public List<AuftragTyp> sucheAuftrage(String kundenName);

    public AuftragTyp sucheAuftragePerNr(String auftragNr);

    public AuftragTyp schliesseAuftrag(Auftrag auftrag);

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot);
}
