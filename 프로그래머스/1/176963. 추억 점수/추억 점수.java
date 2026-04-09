import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if (yearningMap.containsKey(photo[i][j])) {
                    sum += yearningMap.get(photo[i][j]);
                }
            }
            if (sum != 0) {
                answer[i] = sum;
            }
        }

        return answer;
    }
}
