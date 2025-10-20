import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            System.out.println((n + 1) * (n / 2));
        } else {
            System.out.println((n + 1) * (n / 2) + (n / 2 + 1));
        }
    }
}