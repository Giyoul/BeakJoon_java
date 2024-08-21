import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n1 = br.readLine();
        String n2 = br.readLine();
        String n3 = br.readLine();

        int ans = 0;

        if (Character.isDigit(n1.charAt(0))) {
            ans = Integer.parseInt(n1) + 3;
        } else if (Character.isDigit(n2.charAt(0))) {
            ans = Integer.parseInt(n2) + 2;
        } else if (Character.isDigit(n3.charAt(0))) {
            ans = Integer.parseInt(n3) + 1;
        }

        StringBuilder sb = new StringBuilder();

        if (ans % 3 == 0) {
            sb.append("Fizz");
        }
        if (ans % 5 == 0) {
            sb.append("Buzz");
        }
        if (sb.length() == 0) {
            sb.append(ans);
        }

        System.out.println(sb);
    }
}
