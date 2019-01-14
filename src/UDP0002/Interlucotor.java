/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP0002;

import UDP0001.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Interlucotor extends Thread {

    private String nombre;
    private String mensaje;

    public Interlucotor(String nombre, String mensaje) {
        this.nombre = nombre;
        this.setName(nombre);
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        if (this.getName().equalsIgnoreCase("A")) {
            this.enviarMensaje(this.mensaje);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.recibirMensaje();

        } else {
            this.recibirMensaje();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.enviarMensaje(this.mensaje);
        }
    }

    public void enviarMensaje(String mensaje) {
        try {
            InetAddress adressLocal = InetAddress.getByName("localhost");
            byte[] mensajeBytes = mensaje.getBytes();
            int puerto = 5555;

            DatagramPacket packet = new DatagramPacket(mensajeBytes, mensajeBytes.length, adressLocal, puerto);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void recibirMensaje() {
        try {
            byte[] mensajeBytes = new byte[1024];
            int puerto = 5555;
            DatagramPacket packet = new DatagramPacket(mensajeBytes, mensajeBytes.length);
            DatagramSocket socket = new DatagramSocket(puerto);
            socket.receive(packet);
            System.out.println(this.getName()+ "Recibido " + new String(mensajeBytes));
            socket.close();

        } catch (SocketException ex) {
            Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interlucotor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
