import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpLR = new int[n];
        for(int i = 0; i < n; i++){
            dpLR[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
                }
            }
        }

        int[] dpRL = new int[n];
        for(int i = n-1; i >= 0; i--){
            dpRL[i] = 1;
            for (int j = n-1; j >= 0; j--) {
                if(arr[i] > arr[j]){
                    dpRL[i] = Math.max(dpRL[i], dpRL[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dpRL[i] + dpLR[i]);
        }

        System.out.println(max-1);
    }
}