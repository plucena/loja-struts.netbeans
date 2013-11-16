/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unasp.errors;

/**
 *
 * @author sistemas
 */
public class ErroFazAlgo extends Exception {
    
    String mensagem = "Culpa do Estagiario ";
    
    public String toString() {
        return  mensagem;
    }
    
    public ErroFazAlgo(Exception e) {
        mensagem += e;
    }
}
