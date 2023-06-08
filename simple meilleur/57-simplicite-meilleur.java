import java.util.*;

package exercice;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        StringBuilder motActuel = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                motActuel.append(c);
            } else if (motActuel.length() > 0) {
                mots.add(motActuel.toString());
                motActuel.setLength(0);
            }
        }
        if (motActuel.length() > 0) {
            mots.add(motActuel.toString());
        }
        mots.sort((a, b) -> {
            char premiereLettreA = Character.toLowerCase(a.charAt(0));
            char premiereLettreB = Character.toLowerCase(b.charAt(0));

            boolean aInconnu = !ordre.contains(premiereLettreA);
            boolean bInconnu = !ordre.contains(premiereLettreB);

            if (aInconnu && bInconnu) {
                return 0;
            } else if (aInconnu) {
                return 1;
            } else if (bInconnu) {
                return -1;
            } else {
                return Integer.compare(ordre.indexOf(premiereLettreA), ordre.indexOf(premiereLettreB));
            }
        });

        return mots;
    }
}