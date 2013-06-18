package ReSTAdaptor.Verwalter;

import ReSTAdaptor.TransportDatenTypen.TransportListe;
import ReSTAdaptor.TransportDatenTypen.Transporttyp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("transportauftraege")
public class RestKonnektor {

    //@PUT
    @POST
    @Consumes(MediaType.TEXT_XML)
    public Transporttyp postMessage(Transporttyp daten) {
        KonnektorDaten.getInstance().setDaten(daten);
        return daten;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public TransportListe transportauftraege() {
        TransportListe tl = KonnektorDaten.getInstance().getDaten();
        return tl;
    }
}
