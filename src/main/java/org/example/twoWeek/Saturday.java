package org.example.twoWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Saturday {

    static int N; // 가로 크기
    static int M; // 세로 크기
    static boolean visit[][];

    static int dx[] ={-1, 1, 0,0 }; // 상하 좌우 이동 가능
    static int dy[] ={0, 0, -1, 1 };

    static int min = Integer.MIN_VALUE;

    static int map[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1]; // 시작을 (1, 1) 부터 하므로
        visit = new boolean[N+1][M+1];

        for(int i = 1; i <=N; i++){
            String str = br.readLine();
            for(int j = 1; j <=M; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        } // 시작이 (1, 1)이므로 1 부터 초기화



        bfs(1,1); // 넓이 우선 탐색 진행

        sb.append(map[N][M]);

        System.out.println(sb);

    }

    private static void bfs(int x, int y){

        Queue<int []> queue = new LinkedList<>();

        visit[x][y] = true;

        queue.add(new int[] {x,y}); // 큐 하나에 x 와 y 배열을 둠

        while(!queue.isEmpty()){

            int[] f = queue.poll();
            int now_x = f[0];
            int now_y = f[1];

            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y  +dy[i];

                if(next_x >=1 && next_x <=N && next_y >=1 && next_y <=M){ // 이동할 수 있는 범위 탐색
                    if(!visit[next_x][next_y] && map[next_x][next_y] == 1){ // 방문 가능하면
                        queue.add(new int[] {next_x, next_y});
                        visit[next_x][next_y] = true;
                        map[next_x][next_y] = map[now_x][now_y] +1; //최소칸 이동
                    }
                }
            }

        }




    }
}
