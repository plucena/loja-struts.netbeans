/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unasp.action;

import com.unasp.app.PessoasFormJpaController;
import com.unasp.forms.PessoasForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author sistemas
 */
public class PessoasAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private PessoasFormJpaController bd = new PessoasFormJpaController();
    
    public ActionForward Procurar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("PROCURAR");
        PessoasForm pessoa = (PessoasForm)form;
        PessoasForm encontrado = bd.findPessoasForm(pessoa.getCpf());
        HttpSession session = request.getSession();
        session.setAttribute("pessoa", encontrado);
        return mapping.findForward("procurar");
    }

    
    public ActionForward Alterar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {        
        System.out.println("ALTERAR");
        PessoasForm pessoa = (PessoasForm)form;
        bd.edit(pessoa);
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward Cadastrar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("CADASTRAR");
        PessoasForm pessoa = (PessoasForm)form;
        bd.create(pessoa);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward Excluir(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("EXCLUIR");
        PessoasForm pessoa = (PessoasForm)form;
        bd.destroy(pessoa.getCpf());
        return mapping.findForward(SUCCESS);
    }
    
    
}
