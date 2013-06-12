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
public class UDPServer {

    String amAlive = "AM ALIVE";

    public UDPServer() {
        DatagramSocket serverSocket;

        try {
            serverSocket = new DatagramSocket(55555);



            while (true) {
                byte[] receiveData = new byte[256];
                byte[] sendData = new byte[256];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                try {
                    serverSocket.receive(receivePacket);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);

                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();


                sendData = amAlive.getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress, port);
                try {
                    serverSocket.send(sendPacket);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }

    }
}
