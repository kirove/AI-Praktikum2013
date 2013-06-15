/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BankMQAdapter;

import com.rabbitmq.client.*;

/**
 *
 * @author sk
 */
public class EmpfangeZahlungen {
    
    private final static String QUEUE_NAME = "Rechnungen";

    public static void main(String[] argv) throws java.io.IOException, java.lang.InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Warte auf bezahlte Rechnungen...");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.err.println(" [x] Received '" + message + "'");
            //zahlungseingangBuchen(double betrag, String rechnungsNr);
        }
    }
    
}
