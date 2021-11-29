package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

import static com.ipiecoles.java.java220.Entreprise.primeAnnuelleBase;

public class Technicien extends Employe implements Comparable<Technicien>{
    private Integer grade;

    public Technicien(){}

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) throws Exception {
        if(this.grade == null){
            throw  new Exception("Le garde est null");
        }
        super.setSalaire(salaire * (1 + this.grade * 0.1));
    }

    @Override
    public Integer getNbConges() throws Exception {
            return super.getNbConges() + getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() throws Exception {
        return (primeAnnuelleBase() * (1 + grade * 0.1) + Entreprise.PRIME_ANCIENNETE * getNombreAnneeAnciennete());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    public int compareTo(Technicien o) {
        if(this.getGrade() < o.getGrade()){
            return -1;
        } else if (this.getGrade() > o.getGrade()){
            return 1;
        }
        return 0;
    }
}
