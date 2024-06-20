package org.example.twoWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wednesday {


    static int N; //정점의 갯수
    static int M; // 간선의 갯수
    static int map[][];

    static int count = 0;
    static boolean visit[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visit = new boolean[N+1];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;

        }

        for(int i = 1; i < N+1; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        sb.append(count);


        System.out.println(sb);


    }

    private static void dfs(int v){
        visit[v] = true;

        for(int i = 1; i < N+1; i++){
            if(!visit[i] && map[v][i] == 1){
                dfs(i);
            }
        }




    }

    }


