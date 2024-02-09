import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N]; // create new array, size of N

        // String to array
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < N; j++){
            int sum = 0;
            for(int k = j; k < N; k++){
                sum += arr[k];
                if(sum > M){
                    break;
                } else if (sum == M){
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}
