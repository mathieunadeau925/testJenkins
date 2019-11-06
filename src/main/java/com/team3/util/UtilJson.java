package com.team3.util;

import com.team3.model.Lotissement;
import com.team3.model.Terrain;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UtilJson {

    public static JSONObject creerJsonSortie(Terrain terrain) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        JSONObject jsonSortie = new JSONObject();
        jsonSortie.accumulate("valeur_fonciere_totale", nf.format(terrain.getValeur_fonciere_totale()));
        jsonSortie.accumulate("taxe_scolaire", nf.format(terrain.getTaxes_scolaires()));
        jsonSortie.accumulate("taxe_municipale", nf.format(terrain.getTaxes_municipales()));

        JSONArray arraySortie = new JSONArray();
        JSONObject arraySortieObject = new JSONObject();

        Iterator<Lotissement> iterator = terrain.getLotissements().iterator();
        while (iterator.hasNext()) {
            Lotissement lotissement = iterator.next();
            arraySortieObject.accumulate("description", lotissement.getDescription());
            arraySortieObject.accumulate("valeur_par_lot", nf.format(lotissement.getValeur_par_lot()));
            arraySortie.add(arraySortieObject);
            arraySortieObject.clear();
        }

        jsonSortie.accumulate("lotissements", arraySortie);
        return jsonSortie;
    }

    public static void traiterFichierJson(String fichierEntree, String fichierSortie) {

        try {
            //chargement
            String objetJson = FileReader.loadFileIntoString(fichierEntree, "UTF-8");
            JSONObject terrainJson = JSONObject.fromObject(objetJson);

            //creation terrain
            Terrain terrain = Terrain.creerTerrain(terrainJson);

            //test d'affichage
            terrain.afficherTerrain();

            //création json de sortie
            JSONObject jsonSortie = UtilJson.creerJsonSortie(terrain);

            //sauvegarde json de sortie
            FileWriter.saveStringIntoFile(fichierSortie, jsonSortie.toString());
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
        }
    }
}
