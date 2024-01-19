import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9]; // 0~8 total 9 numbers

        String n = br.readLine();

        int stringLength = n.length();
        for(int i = 0; i < stringLength; i++){
            int oneNumber = n.charAt(i) - '0';
            if(oneNumber == 9){ // if number is 9, count as 6
                num[6]++;
            }
            else{
                num[oneNumber]++;   // count number
            }
        }

        if(num[6] % 2 == 0){    // divided by 2 cause we can use 9 as 6
            num[6] /= 2;
        }
        else{
            num[6] = num[6] / 2 + 1;    // round
        }

        int max = 0;
        for(int i : num){   // compare max number
            max = Math.max(max, i);
        }

        System.out.println(max);
    }                           
}
