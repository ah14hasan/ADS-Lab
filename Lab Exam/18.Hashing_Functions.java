// Hashing Functions
import java.util.*;
import java.io.*;

public class HashFunctionsDemo {

    // Division method: h(k) = k mod m
    public static int divisionMethod(int key, int tableSize) {
        return Math.floorMod(key, tableSize);
    }

    // Multiplication method: h(k) = floor(m * ( (k * A) mod 1 ))
    // where 0 < A < 1 (Knuth suggests A ≈ (sqrt(5) - 1) / 2)
    public static int multiplicationMethod(int key, int tableSize) {
        double A = (Math.sqrt(5) - 1) / 2.0;   // about 0.618...[web:91]
        double frac = (key * A) % 1.0;         // fractional part
        return (int) Math.floor(tableSize * frac);
    }

    // Mid-square method: square the key and take middle digits
    // Here we work in decimal and choose middle 2 digits for demo
    public static int midSquareMethod(int key, int tableSize) {
        long square = (long) key * (long) key; // avoid overflow for moderate keys[web:90][web:96]
        String s = Long.toString(square);

        // If length <= 2, just use the number itself
        if (s.length() <= 2) {
            int val = Integer.parseInt(s);
            return Math.floorMod(val, tableSize);
        }

        // Extract middle 2 digits
        int mid = s.length() / 2;
        int start = Math.max(0, mid - 1);
        int end = Math.min(s.length(), start + 2);
        String midDigits = s.substring(start, end);

        int val = Integer.parseInt(midDigits);
        return Math.floorMod(val, tableSize);
    }

    // Folding method: split decimal digits into groups of 2, sum them
    // then take mod tableSize[web:93][web:98]
    public static int foldingMethod(int key, int tableSize) {
        key = Math.abs(key);
        String s = Integer.toString(key);

        int sum = 0;
        // process from right to left in groups of 2 digits
        for (int i = s.length(); i > 0; i -= 2) {
            int start = Math.max(0, i - 2);
            String part = s.substring(start, i);
            sum += Integer.parseInt(part);
        }

        return Math.floorMod(sum, tableSize);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key (integer): ");
        int key = sc.nextInt();

        System.out.print("Enter hash table size (m): ");
        int m = sc.nextInt();

        int hDiv  = divisionMethod(key, m);
        int hMult = multiplicationMethod(key, m);
        int hMid  = midSquareMethod(key, m);
        int hFold = foldingMethod(key, m);

        System.out.println("\nHash values for key = " + key + " and table size m = " + m + ":");
        System.out.println("Division Method      : " + hDiv);
        System.out.println("Multiplication Method: " + hMult);
        System.out.println("Mid-Square Method    : " + hMid);
        System.out.println("Folding Method       : " + hFold);

        sc.close();
    }
}
