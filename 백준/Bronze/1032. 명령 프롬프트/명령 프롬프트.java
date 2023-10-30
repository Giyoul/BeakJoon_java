import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < N-1; i++){
            char[] command = br.readLine().toCharArray();
            for(int j = 0; j < command.length; j++){
                if(arr[j] != command[j]){
                    arr[j] = '?';
                }
            }
        }
        System.out.print(arr);
    }
}
