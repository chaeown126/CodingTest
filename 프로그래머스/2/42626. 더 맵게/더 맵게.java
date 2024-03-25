import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }          
        
        return moreSpicy(pq, K);
    }
    
    private int moreSpicy(PriorityQueue<Integer> pq, int k) {
        int count = 0;
        while(pq.peek() < k) {
            if(pq.size() < 2) {
                count = -1;
                break;
            }
                
            pq.offer(pq.poll() + (pq.poll() * 2));
            count++;
        }
        return count;
    }
}