import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String sen = br.readLine();

            sb.append(sen.charAt(0));
            for (int j = 1; j < sen.length(); j++) {
                if (sen.charAt(j - 1) != sen.charAt(j)) {
                    sb.append(sen.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
