package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.entities.Utilisateur;

public class TestAutoIncrement {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dfePU");
        EntityManager em = emf.createEntityManager();

        Utilisateur u1 = new Utilisateur();
        u1.setNom("Aminata Diallo");
        u1.setEmail("aminata@gmail.com");

        em.getTransaction().begin();

        em.persist(u1);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
