package ReSTAdaptor.Verwalter;

import ReSTAdaptor.TransportDatenTypen.TransportListe;
import ReSTAdaptor.TransportDatenTypen.Transporttyp;
import java.util.ArrayList;
import java.util.List;

public class KonnektorDaten {
	
	private static KonnektorDaten kd = null;
	//private static List<Transportauftragstyp> neueTransportauftraege = new ArrayList<Transportauftragstyp>();
	private List<Transporttyp> neueTransportauftraege = new ArrayList<>();

	private KonnektorDaten() {

	}

	public static KonnektorDaten getInstance(){
		if (kd == null){
			kd = new KonnektorDaten();
		}
		return kd;
	}
	
	public TransportListe getDaten() {
		TransportListe tl = new TransportListe();
		for (Transporttyp tat : neueTransportauftraege) {
			tl.add(tat);
		}
		neueTransportauftraege.clear();
		return tl;
	}

	public void setDaten(Transporttyp daten) {
		neueTransportauftraege.add(daten);
	}

}
