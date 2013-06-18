package ReSTTransportAdaptor.TransportDatenTypen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransportListe {

    public List<Transporttyp> transporte =
            new ArrayList<Transporttyp>();

    public void add(Transporttyp daten) {
        transporte.add(daten);
    }

    public String toString() {
        String ausgabe = "Neue Transportauftraege:";
        for (Transporttyp tat : transporte) {
            ausgabe += tat;
        }
        return ausgabe;
    }
}
