# [Gold V] 두 용액 - 2470 

[문제 링크](https://www.acmicpc.net/problem/2470) 

### 성능 요약

메모리: 29172 KB, 시간: 384 ms

### 분류

이분 탐색, 정렬, 두 포인터

### 제출 일자

2024년 3월 21일 17:21:43

### 문제 설명

<p>KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다. 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.  산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.</p>

<p>같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다. 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다. </p>

<p>예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액이 특성값이 0에 가장 가까운 용액이다. 참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.</p>

<p>산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 전체 용액의 수 N이 입력된다. N은 2 이상 100,000 이하이다. 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다. N개의 용액들의 특성값은 모두 다르고, 산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.</p>

### 출력 

 <p>첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다. 출력해야 하는 두 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.</p>

---
### 소스 설명
정렬이라는 태그만 보고 풀기 시작했는데.. 정렬은 거들 뿐이었던 문제 🥲 (언제까지 속고만 살래..)   
분류에는 이분 탐색도 있지만 이분 탐색은 쓰지 않고 투 포인터까지만 썼다!   

```java
import java.util.*;
import java.io.*;

public class _2470 {
    static int N;
    static int[] solutions;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        solutions = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solutions);

        answer = findTarget(solutions);
        sb.append(answer[0]).append(" ").append(answer[1]);

        System.out.print(sb);

    }

    // 투 포인터 알고리즘 시작
    private static ArrayList<Integer> findTarget(int[] solutions) {
        int[] result = new int[2];
        int start = 0, end = solutions.length - 1; // start, end 설정
        int target = 0, sum = 0, min = 2000000000; // sum은 실제 값 계산용, min은 0과의 오차값 계산용
        while(start < end) {
            sum = solutions[start] + solutions[end];

            if(sum == 0) { // 0일 경우엔 함수를 종료하고 바로 return 하도록 함
                result = new int[2];
                result[0] = solutions[start];
                result[1] = solutions[end];
                break;
            }

            // sum의 절댓값이 min보다 작을 경우, 결과를 재입력
            if(Math.abs(sum) < min){
                result = new int[2];
                result[0] = solutions[start];
                result[1] = solutions[end];
                min = Math.abs(sum); // min도 재입력
            }

            // target인 0이 sum보다 클 경우
            if(target > sum)
                start += 1; // 보다 큰 값을 더하기 위하여 start ++
            else
                end -= 1; // 보다 작은 값을 더하기 위하여 end --
        }

        return result;
    }
}
```
+) ```ArrayList``` => ```int[]``` 로 수정해서 메모리를 조금 더 줄였다..!    
    
![image](https://github.com/zzex3on/CodingTest/assets/87990439/12093d24-8956-459b-9c6d-dee186438556)
