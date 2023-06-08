package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }

        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                motCourant.append(c);
            } else if (motCourant.length() > 0) {
                mots.add(motCourant.toString());
                motCourant.setLength(0);
            }
        }

        if (motCourant.length() > 0) {
            mots.add(motCourant.toString());
        }

        quicksort(mots, orderMap, 0, mots.size() - 1);

        return mots;
    }

    private static void quicksort(List<String> mots, Map<Character, Integer> orderMap, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(mots, orderMap, low, high);
            quicksort(mots, orderMap, low, pivotIndex - 1);
            quicksort(mots, orderMap, pivotIndex + 1, high);
        }
    }

    private static int partition(List<String> mots, Map<Character, Integer> orderMap, int low, int high) {
        String pivot = mots.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareWords(mots.get(j), pivot, orderMap) <= 0) {
                i++;
                swap(mots, i, j);
            }
        }

        swap(mots, i + 1, high);
        return i + 1;
    }

    private static void swap(List<String> mots, int i, int j) {
        String temp = mots.get(i);
        mots.set(i, mots.get(j));
        mots.set(j, temp);
    }

    private static int compareWords(String mot1, String mot2, Map<Character, Integer> orderMap) {
        int minLength = Math.min(mot1.length(), mot2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            int index1 = orderMap.getOrDefault(c1, orderMap.size());
            int index2 = orderMap.getOrDefault(c2, orderMap.size());
            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }
        return Integer.compare(mot1.length(), mot2.length());
    }
}
