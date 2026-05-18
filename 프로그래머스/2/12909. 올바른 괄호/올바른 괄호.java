import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.addLast(c);
            } else {
                if(c == ')' && stack.peekLast() == '(') {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }
        }
        
        if(stack.isEmpty()) return true;

        return false;
    }
}