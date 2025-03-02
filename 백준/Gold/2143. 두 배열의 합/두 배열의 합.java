import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] b;
    static int lenA, lenB;
    static long T;
    static long[] sumA;
    static long[] sumB;
    static long totalCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Long.parseLong(br.readLine());
        lenA = Integer.parseInt(br.readLine());
        a = new int[lenA];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < lenA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sumALength = lenA * (lenA + 1) / 2;
        sumA = new long[sumALength];

        int count = 0;
        for (int i = 0; i < lenA; i++) {
            long sum = 0;
            for(int j = i; j < lenA; j++) {
                sum += a[j];
                sumA[count++] = sum;
            }
        }

        lenB = Integer.parseInt(br.readLine());
        b = new int[lenB];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < lenB; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int sumBLength = lenB * (lenB + 1) / 2;
        sumB = new long[sumBLength];
        count = 0;
        for(int i = 0; i < lenB; i++) {
            long sum = 0;
            for(int j = i; j < lenB; j++) {
                sum += b[j];
                sumB[count++] = sum;
            }
        }

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        int left = 0;
        int right = sumBLength-1;

        while(left < sumALength && right > -1) {
            long sumANum = sumA[left];
            long sumBNum = sumB[right];
            long sum = sumANum + sumBNum;

            if (sum == T) {
                long leftSameNumCount = 0;
                while (left < sumALength && sumA[left] == sumANum) {
                    left++;
                    leftSameNumCount++;
                }

                long rightSameNumCount = 0;
                while (right > -1 && sumB[right] == sumBNum) {
                    right--;
                    rightSameNumCount++;
                }

                totalCount += leftSameNumCount * rightSameNumCount;
            }
            if (sum < T) {
                left++;
            } else if (sum > T) {
                right--;
            }
        }

        System.out.println(totalCount);
    }
}