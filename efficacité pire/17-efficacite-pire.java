package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    
    /**
     * Permet de trier les mots d'une chaîne de caractères selon un ordre donné
     * @param str La chaîne de caractères à trier
     * @param ordre L'ordre à utiliser pour le tri
     * @return Une liste de mots triés selon l'ordre donné
     */
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> listeMots = new ArrayList<>();
        List<String> listeMotsAvecOrdre = new ArrayList<>();
        List<String> listeMotsSansOrdre = new ArrayList<>();

        int i, j;

        // Découpage du texte en mots
        String mot = "";
        char[] texteDecompose = str.toCharArray();
        for (i = 0; i < texteDecompose.length; i++) {
            char c = texteDecompose[i];
            String charTemp = String.valueOf(c);
            if (charTemp.matches("[^a-zA-Z0-9]+")) {
                if (mot.length() > 0) {
                    listeMots.add(mot);
                    mot = "";
                }
            } else {
                mot += c;
            }
        }
        if (mot.length() > 0) {
            listeMots.add(mot);
        }

        // Séparation des mots avec et sans ordre
        for (i = 0; i < listeMots.size(); i++) {
            String motTemp = listeMots.get(i);

            // Vérification si le mot commence par un caractère de l'ordre
            boolean motAvecOrdre = false;
            for (j = 0; j < ordre.size(); j++) {
                if (motTemp.charAt(0) == ordre.get(j)) {
                    listeMotsAvecOrdre.add(motTemp);
                    motAvecOrdre = true;
                }
            }

            // Si le mot ne commence pas par un caractère de l'ordre
            if (!motAvecOrdre) {
                listeMotsSansOrdre.add(motTemp);
            }
        }

        // Tri des mots avec ordre (tri bulle)
        for (i = 0; i < listeMotsAvecOrdre.size()-1; i++) {
            for (j = 0; j < listeMotsAvecOrdre.size()-1; j++) {
                if (compareWithOrder(listeMotsAvecOrdre.get(j), listeMotsAvecOrdre.get(j+1), ordre) > 0) {
                    String temp = listeMotsAvecOrdre.get(j);
                    listeMotsAvecOrdre.set(j, listeMotsAvecOrdre.get(j+1));
                    listeMotsAvecOrdre.set(j+1, temp);
                }
            }
        }

        // Ajout des mots sans ordre à la fin de la liste
        for (i = 0; i < listeMotsSansOrdre.size(); i++) {
            listeMotsAvecOrdre.add(listeMotsSansOrdre.get(i));
        }

        return listeMotsAvecOrdre;
    }

    /**
     * Permet de comparer deux mots selon un ordre donné
     * @param mot1 Le premier mot à comparer
     * @param mot2 Le deuxième mot à comparer
     * @param ordre L'ordre à utiliser pour la comparaison
     * @return Un entier négatif si le premier mot est plus petit que le deuxième, un entier positif si le premier mot est plus grand que le deuxième, 0 si les deux mots sont égaux
     */
    public static int compareWithOrder(String mot1, String mot2, List<Character> ordre) {
        int longueurMotMin = Math.min(mot1.length(), mot2.length());
        
        // On compare les caractères un à un
        for (int i = 0; i < longueurMotMin; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);
            
            // Si les caractères sont différents, on compare leur index dans l'ordre donné
            if (char1 != char2) {
                int index1 = ordre.indexOf(char1);
                int index2 = ordre.indexOf(char2);
                
                if (index1 != -1 && index2 != -1) {
                    return Integer.compare(index1, index2); // ordre déterminé en fonction de l'index si les deux caractères sont présents dans l'ordre spécifié
                } else if (index1 != -1) {
                    return -1;  // mot1 est considéré inférieur
                } else if (index2 != -1) {
                    return 1;   // mot1 est considéré supérieur
                } else {
                    return -1; // cas par défaut
                }
            }
        }
        
        return Integer.compare(mot1.length(), mot2.length()); // si les préfixes sont identiques, la chaîne la plus courte est considérée inférieure
    }    

}
