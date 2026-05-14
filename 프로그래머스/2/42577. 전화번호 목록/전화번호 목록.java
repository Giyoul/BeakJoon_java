import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numberSet = new HashSet<>();
        
        Arrays.stream(phone_book)
            .forEach(value -> numberSet.add(value));
        
        for(String num : phone_book) {
            for(int i = 1; i < num.length(); i++) {
                if(numberSet.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
