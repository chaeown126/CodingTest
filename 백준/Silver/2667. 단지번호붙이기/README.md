# [Silver I] 단지번호붙이기 - 2667 

[문제 링크](https://www.acmicpc.net/problem/2667) 

### 성능 요약

메모리: 14264 KB, 시간: 124 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 2월 29일 19:25:03

### 문제 설명

<p><그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/ITVH9w1Gf6eCRdThfkegBUSOKd.png" style="height:192px; width:409px"></p>

### 입력 

 <p>첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.</p>

### 출력 

 <p>첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.</p>

---
이제야 조금 감이 잡힌다고 느낀 DFS 문제!   
처음에 문제 봤을 때 어렵게 생각했는데 생각보다 어렵지 않았음.. 야호   

```java
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int count;
    static boolean[][] visited; // 방문 여부 판별
    static boolean[][] map; // 지도 정보
    static ArrayList<Integer> complexArr = new ArrayList<>(); // 단지수, 각 단지별 집 개수 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        // 각 배열을 초기화
        visited = new boolean[N+1][N+1];
        map = new boolean[N+1][N+1];

        // map 배열에 지도 정보 입력 (0 : false, 1 : true)
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) == '1' ? true : false;
            }
        }

        // 본격적인 탐색 시작!
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                count = 0;
                DFS(i, j);
                // count가 0보다 큰 경우에만 단지 array에 add하도록 함
                if(count > 0)   complexArr.add(count);
            }
        }
        sb.append(complexArr.size()).append("\n");
        complexArr.stream().sorted().forEach(x -> sb.append(x).append("\n"));

        System.out.print(sb);
    }

    static void DFS(int x, int y) {
        // 집이 없는 곳이거나, 방문했던 곳이면 return
        if(!map[x][y] || visited[x][y])
            return;

        visited[x][y] = true; // 방문 처리
        count++; // 집이 있는 곳이므로 count 올려주기

        // 현재 위치를 기준으로 상,하,좌,우 탐색(재귀)하기
        // 재귀가 완료되면 다시 제자리로 돌아가서 그 다음 방향을 탐색함!
        if(x > 0)   DFS(x-1, y); // 상
        DFS(x+1, y); // 하
        if(y > 0)   DFS(x, y-1); // 좌
        DFS(x, y+1); // 우

    }
}
```
사실 저 상,하,좌,우로 하는 방법이 조금 불편?했는데 의외로 메모리랑 속도가 괜찮았음   
그냥 나 혼자 불편했던걸로 🙃   
좀 더 어려운 DFS 문제를 풀어봐야겠다..!!
