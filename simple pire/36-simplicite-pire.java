package main;

import java.util.List;

public class Exercice {

	public static List<String> solution(String j, List<Character> n) {
        j = j.replace("'", " ");
        j = j.replace(",", "");
        j = j.replace(".", "");
        String[] l = j.split(" ");
        isItTheEnd(l, n);
        return List.of(l);
    }

	private static void isItTheEnd(String[] l, List<Character> n) {
	    for (int i = 0; i < l.length - 1; i++) {
	        for (int j = i + 1; j < l.length; j++) {
	            if (betweenTwo(l[j], l[i], n)) {
	                String temp = l[i];
	                l[i] = l[j];
	                l[j] = temp;
	            }
	        }
	    }
	}

	private static boolean betweenTwo(String z0, String z1, List<Character> n) {
	    int m0 = z0.length();
	    int m1 = z1.length();
	    int ml = Math.min(m0, m1);

	    for (int i = 0; i < ml; i++) {
	        char a0 = z0.charAt(i);
	        char a1 = z1.charAt(i);
	        int i0 = youGuess(n, a0);
	        int i1 = youGuess(n, a1);

	        if (i0 != i1) {
	            return i0 < i1;
	        }
	    }
	    return m0 < m1;
	}

	private static int youGuess(List<Character> n, char l) {
		for (int i = 0; i < n.size(); i++) {
			if (n.get(i) == l) {
				return i;
			}
		}

		return n.size();
	}

}

