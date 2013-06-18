package ReSTTransportAdaptor.Verwalter;

import ReSTTransportAdaptor.TransportDatenTypen.TransportListe;
import ReSTTransportAdaptor.TransportDatenTypen.Transporttyp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("transportauftraege")
public class RestKonnektor {
  //  @PUT
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
