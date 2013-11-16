/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unasp.forms;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author sistemas
 */

@Entity
public class Produto extends org.apache.struts.action.ActionForm  implements Comparable, Serializable {
  
    
    private String nome;
    
    @Id
    private String id;
    
    
    private int quantidade;
    
    
    private float preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    @Override     
    public int compareTo(Object t) {
         String x = ((Produto) t).getNome();
         return this.getNome().compareTo(x);
    }
    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getNome() == null || getNome().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
