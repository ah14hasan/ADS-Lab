// Boyer-Moore Pattern Matching in Java
import java.util.*;
import java.io.*;

public class BoyerMoorePatternMatching {

    // Build bad-character table: for each character in pattern,
    // store its last index in the pattern.
    private static Map<Character, Integer> buildBadCharTable(String pattern) {
        Map<Character, Integer> badChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            badChar.put(pattern.charAt(i), i); // last occurrence[web:142]
        }
        return badChar;
    }

    // Boyer-Moore search using only bad-character heuristic
    public static void boyerMooreSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            System.out.println("Empty pattern.");
            return;
        }

        Map<Character, Integer> badChar = buildBadCharTable(pattern);
        int shift = 0;
        boolean found = false;

        while (shift <= n - m) {
            int j = m - 1;

            // Move from right to left in the pattern
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern found at index " + shift);
                found = true;

                // Shift pattern to align with next possible occurrence
                if (shift + m < n) {
                    char nextChar = text.charAt(shift + m);
                    Integer lastOcc = badChar.get(nextChar);
                    int bcShift = (lastOcc == null) ? m : m - lastOcc - 1;
                    shift += bcShift;
                } else {
                    shift += 1;
                }
            } else {
                // Mismatch at pattern[j]
                char bad = text.charAt(shift + j);
                Integer lastOcc = badChar.get(bad);
                int bcIndex = (lastOcc == null) ? -1 : lastOcc;

                int bcShift = j - bcIndex;
                if (bcShift < 1) {
                    bcShift = 1; // at least shift by 1
                }
                shift += bcShift;
            }
        }

        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Boyer-Moore Pattern Matching Demo (Bad Character Heuristic)");

        System.out.print("Enter the text string: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern string: ");
        String pattern = sc.nextLine();

        boyerMooreSearch(text, pattern);

        sc.close();
    }
}
