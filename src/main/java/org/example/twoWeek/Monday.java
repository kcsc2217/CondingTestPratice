package org.example.twoWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Monday {

    static int map[][];
    static int N, M , V;

    static boolean visit[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 시작 정점

        map = new int[N+1][N+1]; // 간선 배열 초기화 1부터 시작하므로 N+1 로 초기화
        visit = new boolean[N+1];



        // 인접 정점 (즉 정점이 간선으로 연결되어 있으면) 1로 초기화
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(V);
        sb.append("\n");

        visit = new boolean[N+1];


        bfs(V);




        System.out.println(sb);




    }

    static void dfs(int v){
        visit[v] = true;

        sb.append(v).append(" ");

        for(int i = 1; i < N+1; i++){
            if(map[v][i] == 1 && !visit[i]){
                dfs(i);
            }
        }

    }

    static void bfs(int v){
        Queue<Integer> que = new LinkedList<>();
        que.add(v);

        visit[v] = true;

        while(!que.isEmpty()){
            int temp  = que.poll();
            sb.append(temp).append(" ");

            for(int i =1 ; i < N+1; i++){
                if(map[temp][i] == 1 && !visit[i]){
                    que.add(i);
                    visit[i] = true;
                }
            }
        }

    }
}
