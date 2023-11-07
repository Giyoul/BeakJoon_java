import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{  
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            if(check() == true){
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean check() throws IOException{
        String str = br.readLine();
        int prev = -1;
        boolean[] check = new boolean[26];

        for(int j = 0; j < str.length(); j++){
            if(prev != str.charAt(j) - 'a'){
                if(check[str.charAt(j) - 'a'] == false) {
                    check[str.charAt(j) - 'a'] = true;
                    prev = str.charAt(j) - 'a';
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}