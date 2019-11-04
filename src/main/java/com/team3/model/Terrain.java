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
public class Terrain {
    
    private int type_terrain;
    private double prix_m2_min, prix_m2_max;
    private Set<Lotissement> lotissements;

    public Terrain() {
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max, Set<Lotissement> lotissements) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
        this.lotissements = lotissements;
    }

    public int getType_terrain() {
        return type_terrain;
    }

    public void setType_terrain(int type_terrain) {
        this.type_terrain = type_terrain;
    }

    public double getPrix_m2_min() {
        return prix_m2_min;
    }

    public void setPrix_m2_min(double prix_m2_min) {
        this.prix_m2_min = prix_m2_min;
    }

    public double getPrix_m2_max() {
        return prix_m2_max;
    }

    public void setPrix_m2_max(double prix_m2_max) {
        this.prix_m2_max = prix_m2_max;
    }

    public Set<Lotissement> getLotissements() {
        return lotissements;
    }

    public void setLotissements(Set<Lotissement> lotissements) {
        this.lotissements = lotissements;
    }

    @Override
    public String toString() {
        return "Terrain{" + "type_terrain=" + type_terrain + ", prix_m2_min=" + prix_m2_min + ", prix_m2_max=" + prix_m2_max + ", lotissements=" + lotissements + '}';
    }
    
    
    
}
