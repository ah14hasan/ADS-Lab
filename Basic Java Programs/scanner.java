// PROGRAM TO READ INPUT FROM USER USING SCANNER
import java.util.*;
import java.io.*;

class sample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int a = sc.nextInt();

        System.out.print("Enter double: ");
        double b = sc.nextDouble();
        
        // Since nextInt() and nextDouble() leave a newline (\n) character in the input buffer, 
        // you’ll need to consume that leftover newline before calling nextLine().

        sc.nextLine(); // consume the leftover newline

        System.out.print("Enter string: ");
        String str = sc.nextLine(); // reads full line, including spaces

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("str: " + str);

    }
}

