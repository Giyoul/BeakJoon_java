import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean prime[];
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        prime = new boolean[target + 1];

        prime[0] = prime[1] = true;
        for(int i=2; i*i<=target; i++){
            if(!prime[i]){
                for(int j=i*i; j<=target; j+=i) prime[j] = true;
            }
        }

        for(int i=2; i<=target; i++){
            if(!prime[i]){
                primes.add(i);
            }
        }

        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if(sum >= target) sum -= primes.get(start++);
            else if(end == primes.size()) break;
            else sum += primes.get(end++);
            if(target==sum) count++;
        }

        System.out.println(count);
    }
}
