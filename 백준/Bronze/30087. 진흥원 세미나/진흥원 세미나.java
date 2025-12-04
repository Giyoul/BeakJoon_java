import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String sen = br.readLine();
            if (sen.equals("Algorithm")) {
                sb.append("204\n");
            } else if (sen.equals("DataAnalysis")) {
                sb.append("207\n");
            } else if (sen.equals("ArtificialIntelligence")) {
                sb.append("302\n");
            } else if (sen.equals("CyberSecurity")) {
                sb.append("B101\n");
            } else if (sen.equals("Network")) {
                sb.append("303\n");
            } else if (sen.equals("Startup")) {
                sb.append("501\n");
            } else if (sen.equals("TestStrategy")) {
                sb.append("105\n");
            }
        }
        System.out.println(sb);
    }
}