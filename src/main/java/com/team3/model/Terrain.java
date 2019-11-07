package com.team3.model;

import com.team3.util.LoggerLocal;
import com.team3.util.UtilCalcul;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Terrain {

    private int type_terrain;
    private double prix_m2_min, prix_m2_max;
    private ListeLotissements lotissements;
    private double valeur_fonciere_totale;
    private double taxes_scolaires;
    private double taxes_municipales;

    public Terrain() {
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max) {
        this.type_terrain = type_terrain;
        this.prix_m2_min = prix_m2_min;
        this.prix_m2_max = prix_m2_max;
    }

    public Terrain(int type_terrain, double prix_m2_min, double prix_m2_max, ListeLotissements lotissements) {
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

    public ArrayList<Lotissement> getLotissements() {
        return lotissements;
    }

    public void setLotissements(ListeLotissements lotissements) {
        this.lotissements = lotissements;
    }

    public double getValeur_fonciere_totale() {
        return valeur_fonciere_totale;
    }

    public void setValeur_fonciere_totale(double valeur_fonciere_totale) {
        this.valeur_fonciere_totale = valeur_fonciere_totale;
    }

    public double getTaxes_scolaires() {
        return taxes_scolaires;
    }

    public void setTaxes_scolaires(double taxes_scolaires) {
        this.taxes_scolaires = taxes_scolaires;
    }

    public double getTaxes_municipales() {
        return taxes_municipales;
    }

    public void setTaxes_municipales(double taxes_municipales) {
        this.taxes_municipales = taxes_municipales;
    }

    public static Terrain creerTerrain(JSONObject terrainJson) {
        Terrain terrain = null;
        try {
            JSONArray listeJsonLotissements = terrainJson.getJSONArray("lotissements");
            int type_terrain = terrainJson.getInt("type_terrain");
            double prix_m2_min = Double.parseDouble(terrainJson.getString("prix_m2_min").replace(" $", ""));
            double prix_m2_max = Double.parseDouble(terrainJson.getString("prix_m2_max").replace(" $", ""));
            terrain = new Terrain(type_terrain, prix_m2_min, prix_m2_max);
            terrain.setLotissements(ListeLotissements.creerListeLotissements(listeJsonLotissements, terrain));
            terrain.calculerTotalFonciere();
            terrain.calculerTaxesScolaires();
            terrain.calculerTaxesMunicipales();

        } catch (Exception e) {
            LoggerLocal.logErreur(e);
        } finally {
            return terrain;
        }
    }

    public void afficherTerrain() {
        System.out.println("type terrain:" + type_terrain);
        System.out.println("prix au mètre carré minimum: " + prix_m2_min);
        System.out.println("prix au mètre carré maximum: " + prix_m2_max);
        System.out.println("valeur foncière totale: " + valeur_fonciere_totale);
        System.out.println("taxes scolaires: " + taxes_scolaires);
        System.out.println("taxes municipales: " + taxes_municipales);
        lotissements.afficherListeLotissement();
    }

    public void calculerTotalFonciere() {
        final double COUVERTURE_VALEUR_BASE = 733.77;
        double resultat = 0;
        Iterator<Lotissement> iterator = lotissements.iterator();
        while (iterator.hasNext()) {
            Lotissement lotissement = iterator.next();
            resultat += lotissement.getValeur_par_lot();
        }
        resultat += COUVERTURE_VALEUR_BASE;
        valeur_fonciere_totale = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
    }

    private void calculerTaxesScolaires() {
        final double TAUX_TAXES_SCOLAIRES = 0.012;
        double resultat = valeur_fonciere_totale * TAUX_TAXES_SCOLAIRES;
        taxes_scolaires = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
    }

    private void calculerTaxesMunicipales() {
        final double TAUX_TAXES_MUNICIPALES = 0.0225;
        double resultat = valeur_fonciere_totale * TAUX_TAXES_MUNICIPALES;
        taxes_municipales = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
    }
}
