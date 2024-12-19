# [Bronze I] 더하기 사이클 - 1110 

[문제 링크](https://www.acmicpc.net/problem/1110) 

### 성능 요약

메모리: 16492 KB, 시간: 136 ms

### 분류

구현, 수학

### 제출 일자

2024년 12월 19일 19:26:48

### 문제 설명

<p>0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.</p>

<p>26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.</p>

<p>위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.</p>

<p>N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 N의 사이클 길이를 출력한다.</p>

---
쉽게 생각할 수 있는 부분을 너무 꼬아서 메모리랑 시간이 불필요하게 늘어났다ㅠ   
   
숫자를 "잘라서" 해야겠다는 생각때문에 int를 String으로 변환했다가 substring으로 자르고 다시 int로 했다가 ~~(한 마디로 왕뻘짓)~~   
처음 코드를 작성하면서도 '진짜 내 머리에서 이게 최선일까?' 싶었는데 코딩테스트 몇 달간 놓았던 내 탓..🤣   
똥싼 코드로 어찌저찌 __맞았습니다!!__ 가 떴지만 영 찝찝해서 다른 분들의 코드를 훔쳐보다가 몫과 나머지로 아주 쉽게 구현한 코드를 보고 이해한 뒤 직접 작성하여 실행시켰다!   

```
public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        br.close();

        sb.append(cycle(N));
        System.out.print(sb);
    }

    public static int cycle(int num) {
        int cycle = 0;
        int start = num;

        do {
            int x = (start % 10) * 10; // 1의 자리가 10의 자리가 됨
            int y = ((start / 10) + (start % 10)) % 10; // 합계의 1의 자리만 남김
            start = x + y;

            cycle++;
        } while(start != num);

        return cycle;
    }
```
![image](https://github.com/user-attachments/assets/09b8730b-725b-48f0-af35-e13c7037b10d)

메모리, 시간, 코드 길이 모두 꽤나 줄어든 걸 알 수 있다.   
완전 바보였음~ 진작 이렇게 할걸~   
다음부터 숫자 자르기 문제가 나오면 몫과 나머지로 해결 보는거로!
