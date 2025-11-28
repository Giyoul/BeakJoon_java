import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean flag = true;

        while (flag) {
            String name = br.readLine();

            switch (name) {
                case "animal":
                    sb.append("Panthera tigris\n");
                    break;
                case "flower":
                    sb.append("Forsythia koreana\n");
                    break;
                case "tree":
                    sb.append("Pinus densiflora\n");
                    break;
                default:
                    System.out.println(sb);
                    flag = false;
                    break;
            }
        }
    }
}