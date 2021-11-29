package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

import static com.ipiecoles.java.java220.Entreprise.primeAnnuelleBase;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe(){}

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche == null){
            throw new Exception("la date d'embauche ne peut être null");
        }
        if (dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) throws Exception {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete() throws Exception {
        if(dateEmbauche == null){
            throw  new Exception("La date d'embauche est null");
        }
        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }
    public Integer getNbConges() throws Exception {
        return Entreprise.NB_CONGES_BASE;
    }
    public void augmenterSalaire(Double pourcentage) throws Exception {
        if(pourcentage <= 0){
            throw  new Exception("Le pourcentage doit être positif");
        }
        this.salaire = this.salaire * (1 + pourcentage);
    }
    public abstract Double getPrimeAnnuelle() throws Exception;

    @Override
    public String toString() {
        return "Employe{nom='" + nom + "', prenom='" + prenom + "', matricule='" + matricule + "', dateEmbauche=" + dateEmbauche + ", salaire=" + salaire +"}";
    }

    @Override
    public boolean equals(Object o){
        if(this ==  o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Employe e = (Employe) o;
        return Objects.equals(nom, e.nom) &&
                Objects.equals(prenom, e.prenom) &&
                Objects.equals(matricule, e.matricule) &&
                Objects.equals(dateEmbauche, e.dateEmbauche) &&
                Objects.equals(salaire, e.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }
}
