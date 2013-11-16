/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unasp.app;

import com.unasp.app.exceptions.PreexistingEntityException;
import com.unasp.forms.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author sistemas
 */
public class TestaProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ProdutoJpaController p = 
            new ProdutoJpaController(Persistence.createEntityManagerFactory("WebApplication1PU")); 
            Produto p1 = new Produto();
            p1.setId("2");
            p1.setNome("Sorvete");            
            p.create(p1);
            
            Produto p2 = p.findProduto("1");
            System.out.println(p2);
            
            
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(TestaProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }
}
