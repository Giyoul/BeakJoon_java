import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sen = br.readLine();
        String trigger = br.readLine();
        int triggerLength = trigger.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sen.length(); i++){
            sb.append(sen.charAt(i));
//            if(sb.length() > trigger.length()){
//
//            }
            if(sb.length() >= triggerLength){
                boolean flag = true;
                for(int j = triggerLength; j > 0; j--){
                    if (sb.charAt(sb.length() - j) != trigger.charAt(triggerLength - j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.delete(sb.length()-triggerLength, sb.length());
                }
            }
        }

        if ("".equals(sb.toString())) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}