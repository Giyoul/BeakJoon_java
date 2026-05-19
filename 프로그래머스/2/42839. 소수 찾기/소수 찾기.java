import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {    
        char[] numbersArray = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
        
        createNum("", numbersArray, visited);
        numberSet.remove(0);
        numberSet.remove(1);
        
        return countPrime();
    }
    
    private void createNum(String currentNum, char[] numbersArray, boolean[] visited) {
        if(currentNum != "") {
            numberSet.add(Integer.parseInt(currentNum));
        }
        
        for(int i = 0; i < numbersArray.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                createNum(currentNum + numbersArray[i], numbersArray, visited);
                visited[i] = false;
            }
        }
    }
    
    private int countPrime() {
        int total = 0;
        for(int n : numberSet) {
            boolean flag = true;
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) flag = false;
            }
            if(flag) total++;
        }
        return total;
    }
}