class Solution {
    public int solution(int n) {
        int answer = n;
        int repeatCount = n / 2;
        
        for(int i = 1; i <= repeatCount; i++){
            if(n % i == 0){
                answer += i;
            }
        }
        
        return answer;
    }
}