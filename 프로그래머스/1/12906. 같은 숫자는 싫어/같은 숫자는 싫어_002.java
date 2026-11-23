import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int currentValue = arr[0];
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(currentValue != arr[i]) {
                currentValue = arr[i];
                list.add(arr[i]);
            }
        }
        
        int[] answer = list.stream().mapToInt(val -> val.intValue()).toArray();

        return answer;
    }
}