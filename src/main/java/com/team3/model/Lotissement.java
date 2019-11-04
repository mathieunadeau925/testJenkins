/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.model;

import java.util.Date;

/**
 *
 * @author radouaneboutiri
 */
public class Lotissement {
    
    private String descriptions;
    private int nombre_droits_passages, nombre_service,superficie;
    private Date date_mesure;
    //private Terrain terrain;

    public Lotissement() {
    }

//    public Lotissement(String descriptions, int nombre_droits_passages, int nombre_service, int superficie, Date date_mesure, Terrain terrain) {
//        this.descriptions = descriptions;
//        this.nombre_droits_passages = nombre_droits_passages;
//        this.nombre_service = nombre_service;
//        this.superficie = superficie;
//        this.date_mesure = date_mesure;
//        //this.terrain = terrain;
//    }

    public Lotissement(String descriptions, int nombre_droits_passages, int nombre_service, int superficie, Date date_mesure) {
        this.descriptions = descriptions;
        this.nombre_droits_passages = nombre_droits_passages;
        this.nombre_service = nombre_service;
        this.superficie = superficie;
        this.date_mesure = date_mesure;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getNombre_droits_passages() {
        return nombre_droits_passages;
    }

    public void setNombre_droits_passages(int nombre_droits_passages) {
        this.nombre_droits_passages = nombre_droits_passages;
    }

    public int getNombre_service() {
        return nombre_service;
    }

    public void setNombre_service(int nombre_service) {
        this.nombre_service = nombre_service;
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

//    public Terrain getTerrain() {
//        return terrain;
//    }
//
//    public void setTerrain(Terrain terrain) {
//        this.terrain = terrain;
//    }

    @Override
    public String toString() {
        return "Lotissement{" + "descriptions=" + descriptions + ", nombre_droits_passages=" + nombre_droits_passages + ", nombre_service=" + nombre_service + ", superficie=" + superficie + ", date_mesure=" + date_mesure + '}';
    }
    
    
    
    
}
