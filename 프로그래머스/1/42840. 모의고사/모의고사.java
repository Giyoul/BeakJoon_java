import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            if(ans1[i % 5] == answers[i]) correct[0]++;
            if(ans2[i % 8] == answers[i]) correct[1]++;
            if(ans3[i % 10] == answers[i]) correct[2]++;
        }
        
        int maxCorrect = Arrays.stream(correct).max().orElse(0);
        
        List<Integer> list = new ArrayList();
        for(int i = 0; i < 3; i++) {
            if(correct[i] == maxCorrect) list.add(i+1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}