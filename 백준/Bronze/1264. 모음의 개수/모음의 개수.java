import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String sentence = br.readLine();
            if(sentence.equals("#")) break;
            sentence = sentence.toLowerCase();
            
            int length = sentence.length();
            int count = 0;
            for(int i = 0; i < length; i++){
                char ch = sentence.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
