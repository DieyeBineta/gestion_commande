package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Permet d'auto-incrémenter
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // Tout action exercé sur l'utilisateur se repercute sur le profil
    private Profil profil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
