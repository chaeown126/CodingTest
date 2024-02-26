# [Silver II] 연결 요소의 개수 - 11724 

[문제 링크](https://www.acmicpc.net/problem/11724) 

### 성능 요약

메모리: 114180 KB, 시간: 524 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 2월 26일 17:39:59

### 문제 설명

<p>방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.</p>

### 출력 

 <p>첫째 줄에 연결 요소의 개수를 출력한다.</p>

---
DFS의 정석과도 같은 문제를 풀었다!   
첫트에 맞았다고 뜨긴 했는데, 메모리랑 시간이 생각보다 너무 길게 나와서 다른 분들 거 참고하면서 조금씩 수정했당..😅   

### 메모리를 많이 차지했던 이유
노드를 담을 변수인 ```list```를 ```ArrayList```로 썼던 게 문제였다!   
```ArrayList```가 데이터를 추가할 때마다 메모리를 재할당해서 속도가 느린 건 알고 있었는데 이렇게 데이터가 얼마 없는 문제에서도 티가 날 정도 일줄은 몰랐다..허허   
그래서 ```ArrayList[]``` -> ```int[][]``` -> ```boolean[][]``` 으로 차차 수정해가면서 개선했다!   
확실히 ```boolean```이 제일 빠르고 간략화시킬 수 있었고 가독성도 좋은 느낌이었다.   
### 소스 설명
```java
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean [][] list; // ArrayList에서 boolean으로 변경
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1부터 삽입되기 때문에 사이즈 +1
        list = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 그래프이므로 데이터를 각각 넣어줌
            list[u][v] = true;
            list[v][u] = true;
        }

        for(int i = 1; i <= N; i++) {
            // true 로 return 될 경우, 하나의 요소에 대해 모두 방문한 것이기 때문에 count++
            if(DFS(i)){
                count++;
            }
        }
        sb.append(count);
        System.out.print(sb);
    }

    // node가 방문한 node일 경우, false
    // node가 방문하지 않았을 경우, 방문 처리 + 인접한 node에 대해서 DFS 함수 재귀 호출
    private static boolean DFS(int node) {
        if(visited[node])   return false;

        visited[node] = true;
        for(int i = 1; i <= N; i++) {
            if(list[node][i]) {
                DFS(i);
            }
        }

        return true;
    }
}
```
