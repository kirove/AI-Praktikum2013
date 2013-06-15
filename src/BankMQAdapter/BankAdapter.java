/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BankMQAdapter;

import Datentypen.RechnungTyp;
import Exceptions.RechnungException;
import Rechnung.IBank;
import Rechnung.IRechnungFassade;
import Rechnung.RechnungLogic;
import Rechnung.RechnungRepository;
import Rechnung.ZahlungsEingangLogic;
import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sk
 */
public class BankAdapter extends Thread {

    private final static String QUEUE_NAME = "HASPAR";
    IBank ib;
    
    public BankAdapter(){
        this.ib = new ZahlungsEingangLogic();
    }

    public void run() {
        try {
            String rechnungsNr = "";
            double betrag = 0;

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("BankAdapter gestartet...");

            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(QUEUE_NAME, true, consumer);

            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println(" [x] Received '" + message + "'");

                String[] messageParts = message.split("##");
                rechnungsNr = messageParts[0];
                betrag = Double.parseDouble(messageParts[1]);
                
                this.ib.zahlungseingangBuchen(betrag, rechnungsNr);              
                
            }
        } catch (IOException | InterruptedException | ShutdownSignalException | ConsumerCancelledException  ex) {
            Logger.getLogger(BankAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

