package exercice;
import java.util.ArrayList;
import java.util.List;
public class Exercicesobrietemeilleur {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> motsTries = new ArrayList<>();
        String[] motsNonTries = str.split("[^a-zA-Z0-9]+");

        if(str==""){
            return motsTries;
        }
        
        for (char lettre : ordre) {
            for (String mot : motsNonTries) {
                if (!mot.isEmpty() && mot.charAt(0) == lettre) {
                    motsTries.add(mot);
                }
            }
        }

        for (String mot : motsNonTries) {
            if (!motsTries.contains(mot)) {
                motsTries.add(mot);
            }
        }

        return motsTries;
    }
}
