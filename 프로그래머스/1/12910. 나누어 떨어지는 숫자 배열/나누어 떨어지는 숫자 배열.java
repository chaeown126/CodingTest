import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> numList = new ArrayList<>();
        int j = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                numList.add(arr[i]);
                j++;
            }
        }
        
        if(numList.size() < 1) {
            numList.add(-1);
        }
        Collections.sort(numList);
        
        int answer[] = new int[numList.size()];
        int idx = 0;
        for(int num : numList) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}