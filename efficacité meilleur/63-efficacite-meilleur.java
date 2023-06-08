package exercice;

import java.util.List;
import java.util.ArrayList;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<String>();

        ArrayList<String> listeMots = new ArrayList<String>();
        String to_add = "";
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length()) {
                listeMots.add(to_add);
            } else if (str.charAt(i) == ' ') {
                listeMots.add(to_add);
                to_add = "";
            } else {
                to_add += str.charAt(i);
            }
        }

        for (int i = 0; i < ordre.size(); i++) {
            for (int j = 0; j < listeMots.size(); j++) {
                if (listeMots.get(j).charAt(0) == ordre.get(i)) {
                    result.add(listeMots.get(j));
                    listeMots.remove(j);
                }
            }
        }
        for (int i = 0; i < listeMots.size(); i++) {
            if (listeMots.get(i) != null) {
                result.add(listeMots.get(i));
            }
        }
        return result;
    }
}
