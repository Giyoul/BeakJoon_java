import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append((char)(c+32));
            }
            else{
                sb.append((char)(c-32));
            }
        }
        System.out.print(sb);
    }
}
