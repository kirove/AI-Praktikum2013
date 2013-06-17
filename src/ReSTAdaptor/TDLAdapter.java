package ReSTAdaptor;

import Datentypen.AdresseTyp;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import Datentypen.Transportauftragstyp;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

public class TDLAdapter {

    static final String REST_URL = "http://localhost:8080/rest";
    static final String PLACE_PATH = "transportauftraege";
    ClientConfig config;
    WebResource service;
    WebResource subService;
    Client client;

    public TDLAdapter() {
        this.config = new DefaultClientConfig();
        config.getClasses().add(Transporttyp.class);
        this.client = Client.create(config);
        this.service = client.resource(REST_URL);
        this.subService = service.path(PLACE_PATH);
    }

    public void sendeTransportAuftrag(Transportauftragstyp dasZuTransportierendeObjekt) {

        Transporttyp transportObjekt = new Transporttyp();
        transportObjekt.nr = dasZuTransportierendeObjekt.getLieferung().getLieferungNr();
        transportObjekt.kundenname = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getnachName();
        transportObjekt.lieferungErfolgt = dasZuTransportierendeObjekt.getLieferung().isLieferungErfolgt();
        AdresseTyp kundenAdresse = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getAdresse();
        transportObjekt.kundenadresse = "Strasse: " + kundenAdresse.getStrasse() + " HausNr: " + kundenAdresse.getHausNr() + ";" + "\nPLZ: " + kundenAdresse.getPlz() + " Stadt: " + kundenAdresse.getStadt();
        System.out.println("" + transportObjekt.toString());

        /*     service.path("transportauftraege")
         .type(MediaType.TEXT_XML)
         .post(Transporttyp.class, transportObjekt);
         */
        subService.type(MediaType.TEXT_XML).post(Transporttyp.class, transportObjekt);
    }
}
