import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 3 == 0) {
            System.out.println("S");
        } else if (n % 3 == 1) {
            System.out.println("U");
        } else {
            System.out.println("O");
        }
    }
}
