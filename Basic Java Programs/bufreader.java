// PROGRAM TO READ INPUT USING BufferedReader
import java.util.*;
import java.io.*;
class sample3 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter an integer: ");
        int num = Integer.parseInt(br.readLine());

        System.out.println("Enter a double: ");
        double decimal = Double.parseDouble(br.readLine());

        System.out.println("Enter a string: ");
        String text = br.readLine();
        
        System.out.println("Integer: " + num);
        System.out.println("Double: " + decimal);
        System.out.println("String: " + text);
    }
}
