import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sen = br.readLine();

        if (sen.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if (sen.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if (sen.equals("KIS")) {
            System.out.println("Korea International School");
        } else if (sen.equals("SJA")) {
            System.out.println("St. Johnsbury Academy");
        }
    }
}