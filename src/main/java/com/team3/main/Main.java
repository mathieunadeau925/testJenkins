/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.main;

import com.team3.model.*;
import com.team3.util.Agricole;
import com.team3.util.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
        //System.out.println(myJSON);
        JSONObject terrainJSON = JSONObject.fromObject(myJSON);
        JSONArray lotissementJSONArrays = terrainJSON.getJSONArray("lotissements");

        int type_terrain = terrainJSON.getInt("type_terrain");
        String prix_m2_Min = terrainJSON.getString("prix_m2_min").replace(" $", "");
        String prix_m2_max = terrainJSON.getString("prix_m2_max").replace(" $", "");
        //prix_m2_Min = prix_m2_Min.replace(" $", "");
        System.out.println(Double.valueOf(prix_m2_Min));

        Terrain terrainObject = new Terrain(type_terrain, Double.valueOf(prix_m2_Min), Double.valueOf(prix_m2_Min));

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

        sortieJSONArrayBean sortieJSONArrayBean = new sortieJSONArrayBean();
        Set<sortieJSONArrayBean> lotissementsResult = new HashSet<>();
        if (terrainObject.getType_terrain() == 0) {

            for (Lotissement e : lotissements) {
                sortieJSONArrayBean.setDescrptions(e.getDescriptions());
                sortieJSONArrayBean.setValeur_par_lot(String.valueOf(Agricole.calculerValeurLot(e.getSuperficie(), Double.valueOf(terrainObject.getPrix_m2_min()))) + " $");
                lotissementsResult.add(sortieJSONArrayBean);
                System.out.println(sortieJSONArrayBean.toString());
            }
        }
        
//        if (terrainObject.getType_terrain() == 0) {
//            lotissements.forEach((e) -> {
//                sortieJSONArrayBean.setDescrptions(e.getDescriptions());
//                sortieJSONArrayBean.setValeur_par_lot(String.valueOf(Agricole.calculerValeurLot(e.getSuperficie(), Double.valueOf(terrainObject.getPrix_m2_min()))) + " $");
//                lotissementsResult.add(sortieJSONArrayBean);
//                System.out.println(sortieJSONArrayBean.toString());
//
//            });
//        }

        lotissementsResult.forEach((e) -> {
            System.out.println(e);
        });

//        terrainObject.setLotissements(lotissements);
//        System.out.println(terrainObject);
    }
}
