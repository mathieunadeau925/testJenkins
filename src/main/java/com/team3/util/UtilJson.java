package com.team3.util;

import com.team3.model.Lotissement;
import com.team3.model.Terrain;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UtilJson {

    public static JSONObject creerJsonSortie(Terrain terrain) throws Exception {
        
        JSONObject jsonSortie = new JSONObject();
        jsonSortie.accumulate("valeur_fonciere_totale", formatteurDouble(terrain.getValeur_fonciere_totale()));
        jsonSortie.accumulate("taxe_scolaire", formatteurDouble(terrain.getTaxes_scolaires()));
        jsonSortie.accumulate("taxe_municipale", formatteurDouble(terrain.getTaxes_municipales()));

        JSONArray arraySortie = new JSONArray();
        JSONObject arraySortieObject = new JSONObject();

        Iterator<Lotissement> iterator = terrain.getLotissements().iterator();
        while (iterator.hasNext()) {
            Lotissement lotissement = iterator.next();
            arraySortieObject.accumulate("description", lotissement.getDescription());
            arraySortieObject.accumulate("valeur_par_lot", formatteurDouble(lotissement.getValeur_par_lot()));
            arraySortie.add(arraySortieObject);
            arraySortieObject.clear();
        }

        jsonSortie.accumulate("lotissements", arraySortie);
        return jsonSortie;
    }

    public static void traiterFichierJson(String fichierEntree, String fichierSortie) throws Exception {
            //chargement
            String objetJson = FileReader.loadFileIntoString(fichierEntree, "UTF-8");
            JSONObject terrainJson = JSONObject.fromObject(objetJson);

            //creation terrain
            Terrain terrain = Terrain.creerTerrain(terrainJson);

            //création json de sortie
            JSONObject jsonSortie = UtilJson.creerJsonSortie(terrain);

            //sauvegarde json de sortie
            FileWriter.saveStringIntoFile(fichierSortie, jsonSortie.toString());
    }
    
    public static String formatteurDouble(double number) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        String res = nf.format(number);
        res = res.replaceAll(",", ".");
        return res;     
    }
}
