package com.unasp.app;

import com.unasp.errors.ErroFazAlgo;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sistemas
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Login().fazAlgo(0);
        } catch (ErroFazAlgo ex) {
            ex.printStackTrace();
        }
    }
    
    public void fazAlgo(int x) throws ErroFazAlgo {
        Login l = null;        
        try {
         x = 10/0;
         l.fazAlgo(0);  
         System.out.println("Passei por aqui");
        }
        catch(ArithmeticException e) {            
            throw new ErroFazAlgo(e);
        }
        catch(NullPointerException e1) {
            System.out.println("Erro de inicializacao da variavel " + e1);
        }
        System.out.println("Passei por aqui tambem");
    }
    
}
