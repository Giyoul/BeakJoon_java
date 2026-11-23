import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
//         List<String> list = new ArrayList<>(Arrays.asList(strings));
//         list.sort((a, b) -> 
//                  a.charAt(n) != b.charAt(n) ?
//                   a.charAt(n) - b.charAt(n) :
//                   a.compareTo(b));
        
//         return list.toArray(new String[0]);
        
        Arrays.sort(strings, (a, b) -> a.charAt(n) != b.charAt(n)
                    ? a.charAt(n) - b.charAt(n) : a.compareTo(b)
                   );
        return strings;
    }
}