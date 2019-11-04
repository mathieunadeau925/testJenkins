/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.model;

/**
 *
 * @author radouaneboutiri
 */
public class sortieJSONArrayBean {
    
    private String descrptions,valeur_par_lot;

    public sortieJSONArrayBean(String descrptions, String valeur_par_lot) {
        this.descrptions = descrptions;
        this.valeur_par_lot = valeur_par_lot;
    }

    public sortieJSONArrayBean() {
    }

    public String getDescrptions() {
        return descrptions;
    }

    public void setDescrptions(String descrptions) {
        this.descrptions = descrptions;
    }

    public String getValeur_par_lot() {
        return valeur_par_lot;
    }

    public void setValeur_par_lot(String valeur_par_lot) {
        this.valeur_par_lot = valeur_par_lot;
    }

    @Override
    public String toString() {
        return "sortieJSONArrayBean{" + "descrptions=" + descrptions + ", valeur_par_lot=" + valeur_par_lot + '}';
    }
    
}
