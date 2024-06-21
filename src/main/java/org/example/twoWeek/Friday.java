package org.example.twoWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Friday {

    static int N; // 수빈이의 위치
    static int K; // 동생의 위치
    static int visit[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치 초기화
        K = Integer.parseInt(st.nextToken()); //  동생의 위치 쵝화

        visit = new int[100001]; // 위치의 범위가 0 ~ 100,000 까지니깐 배열을 100001개로 초괴화

        int result = bfs(N);

        sb.append(result);


        System.out.println(sb);


    }

    private static int bfs(int node){
        Queue<Integer> que = new LinkedList<>();

        que.add(node); //처음 수빈이의 위치 값 넣어줌
        int index = node; //수빈이의 위치

        int n = 0;

        visit[index] = 1; // 편의상 1초부터 시작으로 바꿈 수빈이의 처음 위치에 1초

        while(!que.isEmpty()){
            n = que.poll(); // 수빈이의 위치 기준값
            if(n == K){ // 수빈이의 위치가 동생의 위치랑 같을때 1초부터 시작헀으므로 -1을 해줌 원래는 0초부터 시작
                return visit[n] -1;
            }
            if(n-1 >=0 && visit[n-1] == 0){ // 위치의 이전값 단 배열의 범위를 벗어나지 않게 0보다는 커야하고 방문하지 않는 곳이여야함
                visit[n-1] = visit[n] + 1;
                que.add(n-1);
            }
            if(n+1 <= 100000 && visit[n+1] == 0){ // 위치의 다음 값 배열의 범위를 벗어나지 않고 100000보다는 작은 값, 방문 하지 않은값
                visit[n+1] = visit[n] +1;
                que.add(n+1);
            }
            if(2 * n <=100000 && visit[2*n] == 0){ // 위치의 두배의 값 배열의 범위를 벗어나지 않고 100000보다는 작은 값, 방문 하지 않은값
                visit[2*n] = visit[n] +1;
                que.add(2*n);
            }
        }

        return -1;
    }
}
