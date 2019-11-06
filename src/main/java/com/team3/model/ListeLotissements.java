package com.team3.model;

import com.team3.util.LoggerLocal;
import com.team3.util.UtilDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListeLotissements extends ArrayList<Lotissement> {

    public void ajouterLotissement(Lotissement lotissement) {
        this.add(lotissement);
    }

    public void retirerLotissement(Lotissement lotissement) {
        this.remove(lotissement);
    }

    public ArrayList retournerListeLotissements() {
        return this;
    }

    public void viderListeLotissement() {
        this.clear();
    }

    public void afficherListeLotissement() {

        Iterator<Lotissement> iterator = this.iterator();
        System.out.println("Lotissements:");
        while (iterator.hasNext()) {
            Lotissement lotissement = iterator.next();
            System.out.println("Description:" + lotissement.getDescription());
            System.out.println("nombre_droits_passage:" + lotissement.getNombre_droits_passage());
            System.out.println("nombre_services:" + lotissement.getNombre_services());
            System.out.println("superficie:" + lotissement.getSuperficie());
            System.out.println("date_mesure:" + lotissement.getDate_mesure());
        }
    }
    
        public static ListeLotissements creerListeLotissements(JSONArray listeJsonLotissements, Terrain terrain) {
        JSONObject iterateurJson;
        ListeLotissements listeLotissements = new ListeLotissements();
        try {
            for (int i = 0; i < listeJsonLotissements.size(); i++) {
                iterateurJson = listeJsonLotissements.getJSONObject(i);
                String descriptions = iterateurJson.getString("description");
                int nbr_droit_passage = iterateurJson.getInt("nombre_droits_passage");
                int nbr_services = iterateurJson.getInt("nombre_services");
                int superficie = iterateurJson.getInt("superficie");
                Date date_mesure = UtilDate.creerDateIso8601(iterateurJson.getString("date_mesure"));
                Lotissement lotissementObject = new Lotissement(descriptions, nbr_droit_passage, nbr_services, superficie, date_mesure);
                lotissementObject.setValeurParLot(terrain);
                lotissementObject.setMontantDroitsPassage();
                lotissementObject.setMontantServices();
                listeLotissements.add(lotissementObject);
            }
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
        } finally {
            return listeLotissements;
        }      
    } 
}
