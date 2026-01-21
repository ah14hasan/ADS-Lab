// Brute Force Pattern Matching in Java
import java.util.*;
import java.io.*;

public class BruteForcePatternMatching {

    // Returns all starting indices where pattern occurs in text
    public static void bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        // For each possible starting position i in text
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Compare pattern[0..m-1] with text[i..i+m-1]
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            // If full pattern matched
            if (j == m) {
                System.out.println("Pattern found at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Brute Force Pattern Matching Demo");

        System.out.print("Enter the text string: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern string: ");
        String pattern = sc.nextLine();

        bruteForceSearch(text, pattern);

        sc.close();
    }
}
