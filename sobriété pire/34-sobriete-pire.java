package exercice;

import java.util.ArrayList;
import java.util.List;

public class ExerciceSobrietePire {
    public static List<String> solution(String str, List<Character> ordre) {
        String[] mots = str.split("[^a-zA-Z0-9]");

        List<String> motsClasses = new ArrayList<>();
        List<String> motsAvecLettreInconnue = new ArrayList<>();

        for (String mot : mots) {
            if (!mot.isEmpty()) {
                if (commenceParLettre(mot, ordre)) {
                    motsClasses.add(mot);
                } else {
                    motsAvecLettreInconnue.add(mot);
                }
            }
        }

        motsClasses = triFusion(motsClasses, ordre);
        motsClasses.addAll(motsAvecLettreInconnue);

        return motsClasses;
    }

    private static List<String> triFusion(List<String> liste, List<Character> ordre) {
        if (liste.size() <= 1) {
            return liste;
        }

        int milieu = liste.size() / 2;
        List<String> gauche = triFusion(liste.subList(0, milieu), ordre);
        List<String> droite = triFusion(liste.subList(milieu, liste.size()), ordre);

        return fusionner(gauche, droite, ordre);
    }

    private static List<String> fusionner(List<String> gauche, List<String> droite, List<Character> ordre) {
        List<String> fusion = new ArrayList<>();
        int indiceGauche = 0;
        int indiceDroite = 0;

        while (indiceGauche < gauche.size() && indiceDroite < droite.size()) {
            String motGauche = gauche.get(indiceGauche);
            String motDroite = droite.get(indiceDroite);

            if (compareMots(motGauche, motDroite, ordre) < 0) {
                fusion.add(motGauche);
                indiceGauche++;
            } else {
                fusion.add(motDroite);
                indiceDroite++;
            }
        }

        fusion.addAll(gauche.subList(indiceGauche, gauche.size()));
        fusion.addAll(droite.subList(indiceDroite, droite.size()));

        return fusion;
    }

    private static boolean commenceParLettre(String mot, List<Character> ordre) {
        if (ordre.isEmpty()) {
            return true;
        }
        char premiereLettre = mot.charAt(0);
        return ordre.contains(premiereLettre);
    }

    private static int compareMots(String mot1, String mot2, List<Character> ordre) {
        int longueurMinimale = Math.min(mot1.length(), mot2.length());

        for (int i = 0; i < longueurMinimale; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);

            if (char1 != char2) {
                int index1 = ordre.indexOf(char1);
                int index2 = ordre.indexOf(char2);

                if (index1 != -1 && index2 != -1) {
                    return Integer.compare(index1, index2);
                } else if (index1 != -1) {
                    return -1;
                } else if (index2 != -1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return Integer.compare(mot1.length(), mot2.length());
    }
}
