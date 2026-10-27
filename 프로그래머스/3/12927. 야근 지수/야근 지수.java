import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);

        long sumOfWorks = 0;

        for (int work : works) {
            sumOfWorks += work;
        }

        if (sumOfWorks <= n) {
            return 0;
        }

        long remainingWorks = sumOfWorks - n;

        int length = works.length;
        int i = 0;

        while (i < length) {
            long averageOfWorks = remainingWorks / (length - i);

            if (works[i] > averageOfWorks) {
                break;
            }

            remainingWorks -= works[i];
            i++;
        }

        int count = length - i;

        long averageOfWorks = remainingWorks / count;
        long remainder = remainingWorks % count;

        long answer = 0;

        for (int j = 0; j < i; j++) {
            answer += (long) works[j] * works[j];
        }

        answer += (count - remainder)
                * averageOfWorks * averageOfWorks;

        answer += remainder
                * (averageOfWorks + 1)
                * (averageOfWorks + 1);

        return answer;
    }
}