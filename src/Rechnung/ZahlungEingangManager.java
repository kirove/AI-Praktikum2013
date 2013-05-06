
package Rechnung;

import java.util.Date;

/**
 *
 * @author NED
 */
public class ZahlungEingangManager {
        public Zahlungseingang erstelleZahlungseingang(int id, Rechnung rechnung, Date datum, double betrag) {
        Zahlungseingang zahlungseingang = new Zahlungseingang(id,  rechnung,  datum,betrag);
       
        return zahlungseingang;
    }
}
