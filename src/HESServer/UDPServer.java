/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HESServer;

import java.io.*;
import java.net.*;

/**
 *
 * @author NED
 */
public class UDPServer extends Thread {

    String amAlive = "AM ALIVE";

    public UDPServer() {
    }

    public void run() {
        DatagramSocket serverSocket;

        try {
            serverSocket = new DatagramSocket(55555);

            while (true) {
                byte[] sendData = new byte[256];
                sendData = amAlive.getBytes();

                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 55555);
                serverSocket.send(sendPacket);
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
