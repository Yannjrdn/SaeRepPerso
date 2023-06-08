package simplicite;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpliciteMeilleur {

    public static List<String> solution(String texte, List<String> ordre) {

        // Expression Regex pour séparer les mots à chaque caractère non-alphabétique
        List<String> decoupage = Arrays.asList(texte.split("[^\\p{L}]"));

        // Tri en fonction de l'ordre
        List<String> resultat = new ArrayList<String>();
        for(int i=0 ; i < ordre.size() ; i++) {
            for(int j=0 ; j < decoupage.size() ; j++) {
                if(decoupage.get(j).startsWith(ordre.get(i))) {
                    resultat.add(decoupage.get(j));
                }
            }
        }

        // Ajout des mots restants
        for(int i=0 ; i < decoupage.size() ; i++) {
            if(!resultat.contains(decoupage.get(i))) {
                resultat.add(decoupage.get(i));
            }
        }

        return resultat;

    }

}