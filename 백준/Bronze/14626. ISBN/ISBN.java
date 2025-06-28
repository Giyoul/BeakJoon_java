import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int sum = 0;
        int weight = 1;

        for (int i = 0; i < 12; i++) {
            char token = number.charAt(i);
            if(token != '*'){
                sum += i % 2 == 0 ? token - '0' : (token - '0') * 3;
            } else {
                weight = i % 2 == 0 ? 1 : 3;
            }
        }

        int left = sum + (number.charAt(12) - '0') % 10;
        for (int i = 0; i < 10; i++) {
            if((left + weight * i) % 10 == 0){
                System.out.println(i);
                break;
            }
        }
    }
}