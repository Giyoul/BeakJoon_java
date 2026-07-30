class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int currentBottle = n;
        
        while(currentBottle >= a) {
            int received = currentBottle / a * b;
            answer += received;
            currentBottle = received + (currentBottle % a);
        }
        
        return answer;
    }
}