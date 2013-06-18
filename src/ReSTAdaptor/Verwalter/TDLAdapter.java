package ReSTAdaptor.Verwalter;

import ReSTAdaptor.TransportDatenTypen.Transporttyp;
import Datentypen.AdresseTyp;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import Datentypen.Transportauftragstyp;
import ReSTAdaptor.ITransportAuftrag;
import ReSTAdaptor.Server_Starten;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

public class TDLAdapter implements ITransportAuftrag {

    static final String REST_URL = "http://localhost:44444/rest";
    static final String PLACE_PATH = "transportauftraege";
    ClientConfig config;
    WebResource service;
    WebResource subService;
    Client client;
    Server_Starten server;
    Transporttyp transportObjekt;

    public TDLAdapter() {
        this.config = new DefaultClientConfig();
        config.getClasses().add(Transporttyp.class);
        this.client = Client.create(config);
        this.service = client.resource(REST_URL);
       // this.subService = service.path(PLACE_PATH);
        this.server = new Server_Starten();
        this.server.start();
        this.transportObjekt = new Transporttyp();
    }

    public void sendeTransportAuftrag(Transportauftragstyp dasZuTransportierendeObjekt) {


        transportObjekt.nr = dasZuTransportierendeObjekt.getLieferung().getLieferungNr();
        transportObjekt.kundenname = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getnachName();
        transportObjekt.lieferungErfolgt = dasZuTransportierendeObjekt.getLieferung().isLieferungErfolgt();
        AdresseTyp kundenAdresse = dasZuTransportierendeObjekt.getLieferung().getAuftrag().getAngebot().getKunde().getAdresse();
        transportObjekt.kundenadresse = "Strasse: " + kundenAdresse.getStrasse() + " HausNr: " + kundenAdresse.getHausNr() + ";" + "\nPLZ: " + kundenAdresse.getPlz() + " Stadt: " + kundenAdresse.getStadt();
        System.out.println("" + transportObjekt.toString());

         service.path("transportauftraege").type(MediaType.TEXT_XML).post(Transporttyp.class, transportObjekt);
        // service.path("transportauftraege").type(MediaType.TEXT_XML).post(String.class, "Hallo");

        //subService.type(MediaType.TEXT_XML).post(Transporttyp.class, transportObjekt);
    }
}
