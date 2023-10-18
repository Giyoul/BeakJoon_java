import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int num1_len = num1.length();
        int num2_len = num2.length();
        long sum = 0;

        for(int i = 0; i < num1_len; i++){
            for(int j = 0; j < num2_len; j++){
                sum += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        System.out.print(sum);        
        
    }
}