package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> listeTrier = new ArrayList<>();

        if (str.length() == 0) {
            List<String> chaineVide = List.of();
            return chaineVide;
        }

        String[] tabMots = str.split("[^a-zA-Z0-9]+");

        List<String> listeMots = new ArrayList<>(Arrays.asList(tabMots));

        for (Character caractere : ordre) {
            List<String> temp = new ArrayList<>();

            for (String mot : tabMots) {
                if (mot.charAt(0) == caractere) {
                    temp.add(mot);
                    listeMots.remove(mot);
                }
            }

            listeTrier.addAll(temp);

        }

        if (!listeMots.isEmpty()) {
            listeTrier.addAll(listeMots);
        }

        return listeTrier;
    }
}