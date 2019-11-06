package com.team3.model;

import com.team3.util.CalculAgricole;
import java.util.Date;

public class Lotissement {

    private String description;
    private int nombre_droits_passage, nombre_services, superficie;
    private Date date_mesure;
    private double valeur_par_lot;
    private double montant_droits_passage;
    private double montant_services;

    public Lotissement(String description, int nombre_droits_passage, int nombre_services, int superficie, Date date_mesure) {
        this.description = description;
        this.nombre_droits_passage = nombre_droits_passage;
        this.nombre_services = nombre_services;
        this.superficie = superficie;
        this.date_mesure = date_mesure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombre_droits_passage() {
        return nombre_droits_passage;
    }

    public void setNombre_droits_passage(int nombre_droits_passage) {
        this.nombre_droits_passage = nombre_droits_passage;
    }

    public int getNombre_services() {
        return nombre_services;
    }

    public void setNombre_services(int nombre_services) {
        this.nombre_services = nombre_services;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Date getDate_mesure() {
        return date_mesure;
    }

    public void setDate_mesure(Date date_mesure) {
        this.date_mesure = date_mesure;
    }

    public double getValeur_par_lot() {
        return valeur_par_lot;
    }

    public void setValeurParLot(Terrain terrain) {
        valeur_par_lot = CalculAgricole.calculerValeurLot(superficie, terrain.getPrix_m2_min());
    }

    public double getMontant_droits_passage() {
        return montant_droits_passage;
    }

    public double getMontant_services() {
        return montant_services;
    }

    public void setMontantDroitsPassage() {
        montant_droits_passage = CalculAgricole.calculerMontantDroitsPassage(nombre_droits_passage, valeur_par_lot);
    }

    public void setMontantServices() {
        montant_services = CalculAgricole.calculerMontantServices();
    }

}
