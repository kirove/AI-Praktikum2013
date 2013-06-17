/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReSTAdaptor;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ng
 */
public class Server_Starten extends Thread{
    
    public void run(){
         try {

            HttpServer server = HttpServerFactory.create("http://localhost:8888/rest");
            server.start();
            JOptionPane.showMessageDialog(null, "Server Beenden?");
//            		TransportListe tl = new TransportListe();
//		tl.transporte = service.path("transportauftraege")
//				.accept( MediaType.TEXT_XML )
//				.get(TransportListe.class).transporte;
//		
//		System.out.println(tl);
            server.stop(0);

        } catch (IOException ex) {
            Logger.getLogger(Server_Starten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Server_Starten.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        
        Server_Starten server = new Server_Starten();
        server.start();
//        try {
//
//            HttpServer server = HttpServerFactory.create("http://localhost:8888/rest");
//            server.start();
//            JOptionPane.showMessageDialog(null, "Server Beenden?");
////            		TransportListe tl = new TransportListe();
////		tl.transporte = service.path("transportauftraege")
////				.accept( MediaType.TEXT_XML )
////				.get(TransportListe.class).transporte;
////		
////		System.out.println(tl);
//            server.stop(0);
//
//        } catch (IOException ex) {
//            Logger.getLogger(Server_Starten.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(Server_Starten.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
