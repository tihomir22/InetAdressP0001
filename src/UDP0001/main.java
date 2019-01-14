/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP0001;

/**
 *
 * @author mati
 */
public class main {

    public static void main(String[] args) throws InterruptedException {
        Interlucotor inter = new Interlucotor("A");
        Interlucotor inter2 = new Interlucotor("B");

        inter.start();
        inter2.start();
        


   
    }
}
