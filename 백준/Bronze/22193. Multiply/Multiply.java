import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = BigInteger.valueOf(Long.parseLong(br.readLine()));
        BigInteger b = BigInteger.valueOf(Long.parseLong(br.readLine()));

        System.out.println(a.multiply(b));
    }
}
