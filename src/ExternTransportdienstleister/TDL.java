package ExternTransportdienstleister;

import ReSTTransportAdaptor.TransportDatenTypen.TransportListe;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TDL {
	
	public static void main(String[] args){
		
		Client create = Client.create();
		WebResource service = create.resource("http://localhost:8080/rest");
			
		TransportListe tl = new TransportListe();
		tl.transporte = service.path("transportauftraege")
				.accept( MediaType.TEXT_XML )
				.get(TransportListe.class).transporte;
		
		System.out.println(tl);

	}

}
