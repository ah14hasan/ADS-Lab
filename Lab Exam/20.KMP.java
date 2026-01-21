// KMP Pattern Matching in Java
import java.util.*;
import java.io.*;

public class KMPPatternMatching {

    // KMP search: print all starting indices where pattern occurs in text
    public static void KMPSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        // Preprocess pattern: build lps[] array
        int[] lps = new int[m];
        computeLPSArray(pattern, m, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern
        boolean found = false;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                found = true;
                j = lps[j - 1]; // continue searching for next match
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    // Build LPS (longest prefix-suffix) array for the pattern
    private static void computeLPSArray(String pattern, int m, int[] lps) {
        int len = 0;   // length of the previous longest prefix-suffix
        lps[0] = 0;    // lps[0] is always 0
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("KMP Pattern Matching Demo");

        System.out.print("Enter the text string: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern string: ");
        String pattern = sc.nextLine();

        KMPSearch(pattern, text);

        sc.close();
    }
}
