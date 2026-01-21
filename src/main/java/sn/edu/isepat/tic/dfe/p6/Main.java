package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.entities.Categorie;
import sn.edu.isepat.tic.dfe.p6.entities.Commande;
import sn.edu.isepat.tic.dfe.p6.entities.Produit;
import sn.edu.isepat.tic.dfe.p6.entities.StatutCommande;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dfePU");
        EntityManager em = emf.createEntityManager();

        Categorie electronique = new Categorie("Electronique", "Appareils high-tech");

        Produit p1 = new Produit("Laptop HP", 899.99, 15);
        Produit p2 = new Produit("Souris sans fil", 29.99, 50);
        Produit p3 = new Produit("Clavier mécanique", 149.99, 20);
        electronique.ajouterProduit(p1);
        electronique.ajouterProduit(p2);
        electronique.ajouterProduit(p3);

        Commande c1 = new Commande(LocalDate.now(), StatutCommande.EN_ATTENTE );
        c1.ajouterProduit(p1);
        c1.ajouterProduit(p2);
        c1.retirerProduit(p3);

        em.getTransaction().begin();

        em.persist(electronique);
        em.persist(c1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

// A la suppression d'une categorie, tous les produits appartenant à celle-ci s'effacent aussi