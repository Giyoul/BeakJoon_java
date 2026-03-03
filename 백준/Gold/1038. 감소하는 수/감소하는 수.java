import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n >= 1023) {
            System.out.println(-1);
            return;
        }
        if (n <= 9) {
            System.out.println(n);
            return;
        }
        for (int i = 0; i < 10; i++) {
            search(1, i);
        }
        Collections.sort(nums);
        System.out.println(nums.get(n));
    }

    public static void search(int depth, long number) {
        if(depth > 10) return;

        nums.add( number);
        for (int i = 0; i < number % 10; i++) {
            search(depth + 1, number * 10 + i);
        }
    }
}
