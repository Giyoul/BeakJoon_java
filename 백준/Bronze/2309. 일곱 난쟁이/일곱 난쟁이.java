import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] num = new int[9];

        for(int i = 0; i < 9; i++){
            int n = Integer.parseInt(br.readLine());
            sum += n;
            num[i] = n;
        }
        
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - num[i] - num[j] == 100){
                    num[i] = 0;
                    num[j] = 0;
                    Arrays.sort(num);
                    for(int k = 2; k < 9; k++){
                        System.out.println(num[k]);
                    }
                    return;
                }
            }
        }
    }
}
