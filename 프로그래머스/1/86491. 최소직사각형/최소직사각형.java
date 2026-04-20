class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes){
            int tmpW = size[0];
            int tmpH = size[1];
            
            if(tmpW < tmpH){
                int tmp = tmpW;
                tmpW = tmpH;
                tmpH = tmp;
            }
            if(maxW < tmpW) {
                maxW = tmpW;
            }
            if(maxH < tmpH) {
                maxH = tmpH;
            }
        }
        
        return maxW * maxH;
    }
}