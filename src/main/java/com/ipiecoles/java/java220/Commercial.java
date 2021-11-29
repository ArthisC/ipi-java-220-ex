package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {
    private Double caAnnuel;
    private Integer performance;

    public Commercial(){}

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        //this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        //egale aux deux lignes du haut car appel du constructeur du dessus
        this.performance = performance;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance){
        this.performance = performance;
    }

    public Double getPrimeAnnuelle(){
        if (caAnnuel == null){
            return 500.0;
        }
        if (caAnnuel / 20 >= 500.0){
            return Math.ceil(caAnnuel / 20);
        }
        return 500.0;
        //return Math.max(Math.ceil(caAnnuel / 20), 500); a la place du if
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) && Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }

    public boolean performanceEgale(Integer performance){
        if (this.performance.equals(performance)){
            return true;
        }
        return false;
    }
}
