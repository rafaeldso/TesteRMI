/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author rafael
 */
public class Servidor extends UnicastRemoteObject implements Primo{

    public Servidor() throws RemoteException{
        super();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Servidor obj = new Servidor();
            Naming.rebind("http://localhost/Primo", obj);
        } catch (RemoteException | MalformedURLException e) {
        }
    }

    @Override
    public int[] calcula(int n) throws RemoteException {
         //To change body of generated methods, choose Tools | Templates.
         
        double raiz = Math.sqrt(n);
        int [] primos = new int[n];
        int indice = 0;
        
        for (int i = 2; i < raiz; i++) {
            for(int j = 1; j < raiz; j++){
                if(i == j){
                    primos[indice] = j;
                    indice++;
                }else{
                    if(j % i == 0){
                       primos[indice] = j;
                       indice++;
                    }
                           
                }
            }
        }
        return primos;
    }
    
}
