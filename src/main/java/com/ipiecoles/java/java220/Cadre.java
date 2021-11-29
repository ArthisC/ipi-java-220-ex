package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe{

    private Double coefficient = 1.0;

    public Cadre(){}

    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
        this.coefficient = coefficient;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public Double getPrimeAnnuelle(){

        return (Entreprise.primeAnnuelleBase() * coefficient);
    }

    @Override
    public String toString() {
        return super.toString() + "Cadre{" + "coefficient=" + coefficient + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre that = (Cadre) o;
        return Objects.equals(coefficient, that.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public Integer getNbConges() throws Exception {
        return (super.getNbConges() + Math.toIntExact(Math.round(this.coefficient)));
    }
}
