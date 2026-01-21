package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.entities.Profil;
import sn.edu.isepat.tic.dfe.p6.entities.Utilisateur;

public class TestAutoIncrement {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dfePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Utilisateur u1 = new Utilisateur();
        u1.setNom("Aminata Diallo");
        u1.setEmail("aminata@gmail.com");

        Profil p1 = new Profil();
        p1.setBio("Directrice");
        p1.setTelephone("77 123 45 67");
        p1.setPhoto("photo.jpeg");

        u1.setProfil(p1);
//        em.persist(p1); Avec le cascade, plus besoin d'enregistrer l'utilisateur et le profil separement
        em.persist(u1);

        Utilisateur u2 = new Utilisateur();
        u2.setNom("Babacar Sy");
        u2.setEmail("babacarsy@gmail.com");
        em.persist(u2);



//        em.remove(u1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
