/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.model;

import java.util.Set;

/**
 *
 * @author radouaneboutiri
 */
public class sortieJSONObjectBean {
    
    private String valeur_fonciere_totale, taxe_Scolaire, taxe_municipale;
    private Set<sortieJSONArrayBean> lotissements;

    public sortieJSONObjectBean() {
    }

    public sortieJSONObjectBean(String valeur_fonciere_totale, String taxe_Scolaire, String taxe_municipale) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
        this.taxe_Scolaire = taxe_Scolaire;
        this.taxe_municipale = taxe_municipale;
    }

    public sortieJSONObjectBean(String valeur_fonciere_totale, String taxe_Scolaire, String taxe_municipale, Set<sortieJSONArrayBean> lotissements) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
        this.taxe_Scolaire = taxe_Scolaire;
        this.taxe_municipale = taxe_municipale;
        this.lotissements = lotissements;
    }

    public String getValeur_fonciere_totale() {
        return valeur_fonciere_totale;
    }

    public void setValeur_fonciere_totale(String valeur_fonciere_totale) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
    }

    public String getTaxe_Scolaire() {
        return taxe_Scolaire;
    }

    public void setTaxe_Scolaire(String taxe_Scolaire) {
        this.taxe_Scolaire = taxe_Scolaire;
    }

    public String getTaxe_municipale() {
        return taxe_municipale;
    }

    public void setTaxe_municipale(String taxe_municipale) {
        this.taxe_municipale = taxe_municipale;
    }

    public Set<sortieJSONArrayBean> getLotissements() {
        return lotissements;
    }

    public void setLotissements(Set<sortieJSONArrayBean> lotissements) {
        this.lotissements = lotissements;
    }

    @Override
    public String toString() {
        return "{" + "\"valeur_fonciere_totale\":" + valeur_fonciere_totale + ", \"taxe_Scolaire\":" + taxe_Scolaire + ", \"taxe_municipale\":" + taxe_municipale + ", \"lotissements\":" + lotissements + '}';
    }
}
