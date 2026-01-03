import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int count = 3;
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());

            sum += n * count;
            count++;
        }

        System.out.println(sum);
    }
}
