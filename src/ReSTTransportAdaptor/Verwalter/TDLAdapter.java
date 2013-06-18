package ReSTTransportAdaptor.Verwalter;

import ReSTTransportAdaptor.TransportDatenTypen.Transporttyp;
import Datentypen.AdresseTyp;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import Datentypen.Transportauftragstyp;
import ReSTTransportAdaptor.ITransportAuftrag;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TDLAdapter implements ITransportAuftrag {

    static final String REST_URL = "http://localhost:8080/rest";
    static final String PLACE_PATH = "transportauftraege";
    ClientConfig config;
    WebResource service;
    WebResource subService;
    Client client;
    Transporttyp transportObjekt;

    public TDLAdapter() {
        this.config = new DefaultClientConfig();
        config.getClasses().add(Transporttyp.class);
        this.client = Client.create(config);
        this.service = client.resource(REST_URL);
        this.subService = service.path(PLACE_PATH);
        this.transportObjekt = new Transporttyp();
    }

    @Override
    public void sendeTransportAuftrag(Transportauftragstyp dasZuTransportierendeObjekt) {

        transportObjekt.nr = dasZuTransportierendeObjekt.getLieferung().getLieferungNr();
        transportObjekt.kundenname = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getnachName();
        transportObjekt.lieferungErfolgt = dasZuTransportierendeObjekt.getLieferung().isLieferungErfolgt();
        AdresseTyp kundenAdresse = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getAdresse();
        transportObjekt.kundenadresse = "Strasse: " + kundenAdresse.getStrasse() + " HausNr: " + kundenAdresse.getHausNr() + ";" + "\nPLZ: " + kundenAdresse.getPlz() + " Stadt: " + kundenAdresse.getStadt();
        System.out.println("" + transportObjekt.toString());

        service.path("transportauftraege").type(MediaType.TEXT_XML).post(Transporttyp.class, transportObjekt);

    }
}
