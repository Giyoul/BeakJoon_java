import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        
        List<Integer> list = new ArrayList<>();
        for(int val : arr) list.add(val);
        list.remove(Collections.min(list));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}