import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] a) {
        if (a.length <= 2) {
            return a.length;
        }

        int[] rightMin = new int[a.length];
        rightMin[a.length - 1] = a[a.length - 1];
        
        for (int i = a.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int answer = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= leftMin || a[i] <= rightMin[i]) {
                answer++;
            }
            
            leftMin = Math.min(leftMin, a[i]);
        }

        return answer;
    }
}