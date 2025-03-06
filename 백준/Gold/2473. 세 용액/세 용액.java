import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] arr, pickedNum;
    static int start, mid, end;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        pickedNum = new long[3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            start = i;
            mid = i+1;
            end = n-1;

            while(mid != end){
                long sum = arr[start] + arr[mid] + arr[end];
                if (Math.abs(sum) < min) {
                    pickedNum[0] = arr[start];
                    pickedNum[1] = arr[mid];
                    pickedNum[2] = arr[end];
                    min = Math.abs(sum);
                }
                if(sum < 0){
                    mid++;
                } else if (sum > 0) {
                    end--;
                } else {
                    break;
                }
            }
        }

        System.out.println(pickedNum[0] + " " + pickedNum[1] + " " + pickedNum[2]);
    }
}