import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");

        // String 배열을 int로 변환 >> 뭔가 더 간편하게 하는 방법이 있을 듯 하긴 함.
        int[] intArrA = new int[length];
        int[] intArrB = new int[length];
        for(int i = 0; i < length; i++){
            intArrA[i] = Integer.parseInt(arrA[i]);
            intArrB[i] = Integer.parseInt(arrB[i]);
        }

        // 정렬
        Arrays.sort(intArrA);
        Arrays.sort(intArrB);

        // 최소값의 합
        int sum = 0;
        for(int i = 0; i < length; i++){
            // System.out.println("a = " + arrA[i] + ", b = " + arrB[i]);
            sum += intArrA[i] * intArrB[length - i - 1];
        }

        System.out.println(sum);
    }                           
}
