package services;

import entities.Artist;
import entities.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class CDService {

    //CRUD

    EntityManager em = null;
    EntityTransaction tx = null;

    public CDService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CD createCD(String title, String description,Integer year, Set<Artist> artists){

        CD cd = new CD(title, description,year, artists);
        cd.setTitle(title);
        cd.setArtists(artists);
        cd.setDescription(description);
        cd.setYear(year);

        tx.begin();
        em.persist(cd);
        tx.commit();

        return cd;
    }

    public CD createCD(CD cd){
        tx.begin();
        em.persist(cd);
        tx.commit();
        return cd;
    }

    public CD findCD(Long id) {
        return em.find(CD.class, id);
    }

    public void removeCD(Long id){
        CD cd = em.find(CD.class, id);
        if(cd != null){
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
    }

    public void removeCD(CD cd){
        CD cdToBeDeleted = em.merge(cd);
        tx.begin();
        em.remove(cdToBeDeleted);
        tx.commit();

    }

    }



