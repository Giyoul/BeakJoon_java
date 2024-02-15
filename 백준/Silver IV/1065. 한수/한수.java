import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        if(x < 100){
            System.out.print(x);
            return;
        }

        int count = 99; // if x is over 99 count the 한수
        for(int i = 100; i <= x; i++){
            int one = i%10;
            int ten = i%100/10;
            int hun = i%1000/100;

            if(hun-ten == ten-one) count++;
        }
        if(x == 1000) count--;  // if x is 1000, the above is wrong | cause in this case one ten hun is 0, so count plused;

        System.out.print(count);
    }
}
