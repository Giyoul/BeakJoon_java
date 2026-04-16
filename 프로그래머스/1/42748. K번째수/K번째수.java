import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int[] command : commands) {
            int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(arr);
            answer[index++] = arr[command[2] - 1];
        }
        
        return answer;
    }
}