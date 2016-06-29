/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public class Cliente {
    static Primo obj = null;
    public static void main(String args[]) throws NotBoundException, MalformedURLException, RemoteException{
        
        obj = (Primo) Naming.lookup("http://localhost/Primos");
        
        System.out.println("Informe um número para o calculo dos primos: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] resposta = obj.calcula(n);
        System.out.println("Primos: ");
        for(int i = 0; i < resposta.length; i++){
            System.out.println(resposta[i]);
        }
    }
}
