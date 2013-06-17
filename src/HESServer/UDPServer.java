
package HESServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class UDPServer extends Thread {

    String amAlive = "AM ALIVE";
    int udpPort = 55555;
    int sendingFrequence = 2000;

    public void run() {
        DatagramSocket serverSocket;

        try {
            serverSocket = new DatagramSocket(udpPort);

            while (true) {
                System.out.println("Broadcasting..." + amAlive + " on Port: " + udpPort);
                byte[] sendData = new byte[256];
                sendData = amAlive.getBytes();

                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), udpPort);
                serverSocket.send(sendPacket);
                sleep(sendingFrequence);
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
