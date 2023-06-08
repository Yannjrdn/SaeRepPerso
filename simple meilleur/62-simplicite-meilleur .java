package exercice;

import java.util.*;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> words = new ArrayList<>();
        String[] wordArray = str.split("\\s+");
        for (String word : wordArray) {
            if (word.endsWith(",")) {
                word = word.substring(0, word.length() - 1);
            }
            String[] subWords = word.split("'");
            for (String subWord : subWords) {
                words.add(subWord);
            }
        }

        words.sort((a, b) -> {
            int minLength = Math.min(a.length(), b.length());
            for (int i = 0; i < minLength; i++) {
                char charA = Character.toLowerCase(a.charAt(i));
                char charB = Character.toLowerCase(b.charAt(i));
                int indexA = ordre.indexOf(charA);
                int indexB = ordre.indexOf(charB);
                if (indexA == -1 && indexB == -1) {
                    continue;
                } else if (indexA == -1) {
                    return 1;
                } else if (indexB == -1) {
                    return -1;
                } else if (indexA != indexB) {
                    return Integer.compare(indexA, indexB);
                }
            }
            return Integer.compare(a.length(), b.length());
        });

        return words;
    }
}