/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetadressp0001;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class InetAdressP0001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        Scanner sc = new Scanner(System.in);
        InetAddress direcc = null;
        String host;
        String[] segmentos;
        byte[] ip = new byte[4];
        int op = 999;

        while (op != 0) {
            mostrarMenu();
            op = sc.nextInt();
            sc.nextLine();
            host = sc.nextLine();
            if (op == 1) {
                segmentos = host.trim().split("\\.");
                System.out.println("Host "+ segmentos[0].toString());
                for (int i = 0; i < segmentos.length; i++) {
                    ip[i] = (byte) Integer.parseInt(segmentos[i]);
                }
                direcc = InetAddress.getByAddress(ip);
                System.out.println("Nom de " + host + ": " + direcc.getHostName());
            } else {

                direcc = InetAddress.getByName(host);
                System.out.println("IP de " + host + ": " + direcc.getHostAddress());
            }
            mostrarInfo(host, direcc);

        }
        sc.close();

    }

    public static void mostrarInfo(String host, InetAddress direcc) throws UnknownHostException {
        System.out.println("DNS asociat a " + host + ": " + direcc.getCanonicalHostName());
        System.out.println("Adreça completa: " + direcc.toString());
        if (direcc.isMulticastAddress()) {
            System.out.println("La direcció " + host + " es una direcció multicast");
            if (direcc.isMCGlobal()) {
                System.out.println("La direcció " + host + " té abast global");
            } else {
                System.out.println("La direcció " + host + " té abast local");
            }
        } else {
            System.out.println("La direcció " + host + " es una direcció unicast");
        }
        System.out.println("----------------------");
        System.out.println("Adreça local: " + direcc.getLocalHost());

    }

    public static void mostrarMenu() {
        System.out.println("1.- Introducir una IP");
        System.out.println("2.- Introducir un nombre de host");
        System.out.println("0.-Salir");
    }

}
