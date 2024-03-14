# [Silver I] 신입 사원 - 1946 

[문제 링크](https://www.acmicpc.net/problem/1946) 

### 성능 요약

메모리: 314796 KB, 시간: 2988 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2024년 3월 14일 15:47:54

### 문제 설명

<p>언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.</p>

<p>그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.</p>

<p>이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.</p>

### 출력 

 <p>각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.</p>

---
### 소스 설명
1. 점수가 아닌 __순위__ 임을 이해할 것
2. 1차 서류심사 순위별로 __정렬__ 후 2차 면접 결과에 대해 __그리디 알고리즘__ 수행

```java
import java.util.*;
import java.io.*;

public class Main {
    static int T, N; // T : 테스트케이스, N : 테스트케이스 별 인원 수
    static int[][] scoreArr; // 1차, 2차 순위가 담길 2차원 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken()); // 테스트케이스 입력
        // 테스트케이스만큼 반복문 진행 (최대 20으로 시간/메모리는 크게 차지하지 않을 것으로 보임)
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            scoreArr = new int[N][2]; // 인원 수(N)별로 1차와 2차 점수 총 두 값만 들어가므로 사이즈는 [N][2]로 지정
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scoreArr[j][0] = Integer.parseInt(st.nextToken()); // 1차 결과 순위
                scoreArr[j][1] = Integer.parseInt(st.nextToken()); // 2차 결과 순위
            }
            sb.append(empSelect(scoreArr)).append("\n");
        }
        System.out.print(sb);
    }

    // 정렬 + 그리디 알고리즘 수행 함수
    private static int empSelect(int[][] scoreArr) {
        // 1차 결과에 대해 오름차순으로 정렬
        Arrays.sort(scoreArr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        // 1차 1위는 반드시 합격이므로 count = 1로 지정
        // min의 초기값은 1차 1위의 2차 순위값을 기준으로 함, 이미 1차 순위별로 정렬되어 있기 때문에 2차까지 낮을 경우 count를 하지 않으면 되기 때문
        int count = 1, min = scoreArr[0][1];

        for(int i = 1; i < N; i++) {
            // 2차 순위가 min 값보다 더 작으면(순위 상으로는 높은 의미) count++, min의 값을 수정
            if(scoreArr[i][1] < min) {
                count++;
                min = scoreArr[i][1];
            }
        }
        return count;
    }
}

```

정렬보다는 그리디 알고리즘 중심이어서 살짝 당황스러웠던 문제,,   
그리디 알고리즘에도 얼른 익숙해져야겠다 
