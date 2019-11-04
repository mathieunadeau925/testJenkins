/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.main;

import com.team3.model.*;
import com.team3.util.Agricole;
import com.team3.util.FileReader;
import com.team3.util.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author radouaneboutiri
 */
public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        String myJSON = FileReader.loadFileIntoString("ressources/terrain1.json", "UTF-8");
        JSONObject terrainJSON = JSONObject.fromObject(myJSON);
        JSONArray lotissementJSONArrays = terrainJSON.getJSONArray("lotissements");

        int type_terrain = terrainJSON.getInt("type_terrain");
        String prix_m2_min = terrainJSON.getString("prix_m2_min").replace(" $", "");
        String prix_m2_max = terrainJSON.getString("prix_m2_max").replace(" $", "");
        Terrain terrainObject = new Terrain(type_terrain, Double.valueOf(prix_m2_min), Double.valueOf(prix_m2_max));

        JSONObject lotsJSONObject;
        String desciptions = null;
        int nbr_droit_passage = 0, nbr_services = 0, superficier = 0;
        Date date_mesure;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());

        Lotissement lotissementObject = null;
        Set<Lotissement> lotissements = new HashSet<>();

        for (int i = 0; i < lotissementJSONArrays.size(); i++) {
            lotsJSONObject = lotissementJSONArrays.getJSONObject(i);
            desciptions = lotsJSONObject.getString("description");
            nbr_droit_passage = lotsJSONObject.getInt("nombre_droits_passage");
            nbr_services = lotsJSONObject.getInt("nombre_services");
            superficier = lotsJSONObject.getInt("superficie");
            date_mesure = format.parse(lotsJSONObject.getString("date_mesure"));
            lotissementObject = new Lotissement(desciptions, nbr_droit_passage, nbr_services, superficier, date_mesure);
            lotissements.add(lotissementObject);
        }
        terrainObject.setLotissements(lotissements);
        lotissements.forEach((e) -> {
            System.out.println(e);
        });

        System.out.println(terrainObject.toString());

        sortieJSONArrayBean sortieJSONArrayBean;;
        Set<sortieJSONArrayBean> lotissementsResult = new HashSet<sortieJSONArrayBean>();

        for (Lotissement elem : terrainObject.getLotissements()) {
            sortieJSONArrayBean = new sortieJSONArrayBean();
            sortieJSONArrayBean.setDescrptions(elem.getDescriptions());
            sortieJSONArrayBean.setValeur_par_lot(String.valueOf(Agricole.calculerValeurLot(elem.getSuperficie(), Double.valueOf(terrainObject.getPrix_m2_min()))) + " $");
            lotissementsResult.add(sortieJSONArrayBean);
            System.out.println(sortieJSONArrayBean.toString());
        }

        lotissementsResult.forEach((e) -> {
            System.out.println(e);
        });

        double valeur_fonciere_total = calculerTotalFonciere(lotissementsResult);
        System.out.println(valeur_fonciere_total);

        double taux_scolaire = calculerTauxScolaire(valeur_fonciere_total);
        System.out.println(taux_scolaire);

        double taux_taxe_municipale = calculerTaxeMunicipale(valeur_fonciere_total);
        System.out.println(taux_taxe_municipale);
        
        
        sortieJSONObjectBean sortieJSONObjectB = new sortieJSONObjectBean(
                "\""+String.valueOf(valeur_fonciere_total)+" $\"", 
                String.valueOf(taux_scolaire)+" $", 
                String.valueOf(taux_taxe_municipale)+" $",
                lotissementsResult
        );
        
        System.out.println(sortieJSONObjectB.toString());
        
        FileWriter.saveStringIntoFile("ressources/terrainRes.json", sortieJSONObjectB.toString());
    }

    private static double calculerTotalFonciere(Set<sortieJSONArrayBean> lotissementsResult) {
        final double COUVIRTURE_VALEUR_BASE = 733.77;
        double resultat = 0;
        for (sortieJSONArrayBean elem : lotissementsResult) {
            resultat += Double.parseDouble(elem.getValeur_par_lot().replace(" $", ""));
        }
        return resultat + COUVIRTURE_VALEUR_BASE;
    }

    private static double calculerTauxScolaire(double valeur_fonciere_total) {
        DecimalFormat df = new DecimalFormat("#.#####");
        final double TAUX_TAXE_SCOLAIRE = 0.012;
        return Double.parseDouble(df.format(valeur_fonciere_total * TAUX_TAXE_SCOLAIRE));
    }

    private static double calculerTaxeMunicipale(double valeur_fonciere_total) {
        DecimalFormat df = new DecimalFormat("#.#####");
        final double TAUX_TAXE_MUNICIPALE = 0.0225;
        return Double.parseDouble(df.format(valeur_fonciere_total * TAUX_TAXE_MUNICIPALE));
    }
}
