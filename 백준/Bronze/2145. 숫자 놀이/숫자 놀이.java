import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num;
        while (!"0".equals(num = br.readLine())) {
            while (true) {
                int calc = 0;
                for (int i = 0; i < num.length(); i++) {
                    calc += Integer.parseInt(String.valueOf(num.charAt(i)));
                }
                if(calc < 10){
                    sb.append(calc).append("\n");
                    break;
                }
                num = String.valueOf(calc);
            }
        }

        System.out.println(sb);
    }
}