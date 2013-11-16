/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unasp.app;

import com.unasp.app.exceptions.NonexistentEntityException;
import com.unasp.app.exceptions.PreexistingEntityException;
import com.unasp.forms.PessoasForm;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sistemas
 */
public class PessoasFormJpaController implements Serializable {
    
    public PessoasFormJpaController() {
        this.emf = Persistence.createEntityManagerFactory("WebApplication1PU");
    }

    public PessoasFormJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoasForm pessoasForm) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pessoasForm);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPessoasForm(pessoasForm.getCpf()) != null) {
                throw new PreexistingEntityException("PessoasForm " + pessoasForm + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoasForm pessoasForm) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pessoasForm = em.merge(pessoasForm);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pessoasForm.getCpf();
                if (findPessoasForm(id) == null) {
                    throw new NonexistentEntityException("The pessoasForm with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoasForm pessoasForm;
            try {
                pessoasForm = em.getReference(PessoasForm.class, id);
                pessoasForm.getCpf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoasForm with id " + id + " no longer exists.", enfe);
            }
            em.remove(pessoasForm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoasForm> findPessoasFormEntities() {
        return findPessoasFormEntities(true, -1, -1);
    }

    public List<PessoasForm> findPessoasFormEntities(int maxResults, int firstResult) {
        return findPessoasFormEntities(false, maxResults, firstResult);
    }

    private List<PessoasForm> findPessoasFormEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoasForm.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PessoasForm findPessoasForm(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoasForm.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoasFormCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoasForm> rt = cq.from(PessoasForm.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
