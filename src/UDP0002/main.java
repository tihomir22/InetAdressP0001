/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP0002;

import UDP0001.*;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class main {

    public static void main(String[] args) throws InterruptedException {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce mensaje de A");
        String introducido = teclado.nextLine();
        System.out.println("Introduce mensaje de B");
        String introducido2 = teclado.nextLine();

        while (!introducido.equalsIgnoreCase("adeu") && !introducido2.equalsIgnoreCase("adeu")) {
            Interlucotor inter = new Interlucotor("A", introducido);
            Interlucotor inter2 = new Interlucotor("B", introducido2);

            inter.start();
            inter2.start();
            
            inter.join();
            inter2.join();
      
            
            System.out.println("Introduce mensaje de A");
            introducido = teclado.nextLine();
            System.out.println("Introduce mensaje de B");
            introducido2 = teclado.nextLine();
        }

    }
}
