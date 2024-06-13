/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprog2.persistencia;

import com.mycompany.finalprog2.logica.Hospital;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author lpela
 */
public class HospitalJpaController {
    
    
    public HospitalJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public HospitalJpaController(){
        emf = Persistence.createEntityManagerFactory("finalProg2PU");
    }
    private EntityManagerFactory emf = null;
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
}

    public void create(Hospital hos) {
        
    EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void edit(Hospital hos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hos = em.merge(hos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = hos.getId();
                if (findHos(id) == null) {
                    throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hospital hos;
            try {
                hos = em.getReference(Hospital.class, id);
                hos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hospital with id " + id + " no longer exists.", enfe);
            }
            em.remove(hos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hospital> findHospitalEntities() {
        return findHospitalEntities(true, -1, -1);
    }

    public List<Hospital> findHospitalEntities(int maxResults, int firstResult) {
        return findHospitalEntities(false, maxResults, firstResult);
    }

    private List<Hospital> findHospitalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hospital.class));
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

    public Hospital findHospital(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hospital.class, id);
        } finally {
            em.close();
        }
    }

    public int getHospitalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hospital> rt = cq.from(Hospital.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

    

