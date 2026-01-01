import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sen = br.readLine();

        if (sen.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if (sen.equals("CODE")) {
            System.out.println("MASTER");
        } else if (sen.equals("2023")) {
            System.out.println("0611");
        } else if (sen.equals("ALGORITHM")) {
            System.out.println("CONTEST");
        }
    }
}
