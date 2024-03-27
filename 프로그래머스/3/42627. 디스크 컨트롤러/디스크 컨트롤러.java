import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        // int sum = 0;
        int time = 0;
        int idx = 0;
        int answer = 0;
        int len = jobs.length;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 1. 현재 시간보다 작거나 같은 요청 시간 큐에 추가
        // 2. 큐에 작업이 없다면 작업 요청시점이 가장 빠른 작업 추가 (add)
        // 3. 큐에 작업이 있다면 작업 소요시간이 가장 빠른 작업 수행 (poll)
        
        while(!pq.isEmpty() || idx < len) {
            while(idx < len && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
            }
        }
        
//         sum = jobs[0][1]; 
//         int endTime = sum; // end Point
//         System.out.println(endTime);
//         for(int i = 1; i < jobs.length; i++) {
//             sum += (endTime - jobs[i][0]) + jobs[i][1];
//             endTime += jobs[i][1];
//             System.out.println(endTime);
//         }
        
//         int avg = sum / jobs.length;
//         return avg;
        return answer / len;
    }
}