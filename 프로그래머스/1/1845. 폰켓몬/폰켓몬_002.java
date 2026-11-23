import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        
        for(int num : nums) {
            hashSet.add(num);
        }
        
        return hashSet.size() >= nums.length / 2 ? nums.length / 2 : hashSet.size();
    }
}