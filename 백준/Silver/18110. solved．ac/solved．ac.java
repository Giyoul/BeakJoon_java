import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grade = new int[n];

        for(int i = 0; i < n; i++){
            grade[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(grade);
        int fifteen = (int) Math.round(n / 100.0 * 15.0);
        for(int i = 0; i < fifteen; i++){
            grade[i] = 0;
            grade[n-i-1] = 0;
        }
        
        Arrays.sort(grade);
        int sum = 0;
        for(int i = fifteen * 2; i < n; i++){
            sum += grade[i];
        }
        System.out.print((int)Math.round(sum / (double)(n - fifteen * 2)));
    }
}
