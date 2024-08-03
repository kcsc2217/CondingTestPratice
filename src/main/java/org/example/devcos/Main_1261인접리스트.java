package org.example.devcos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261인접리스트 {

    static boolean visit[];

    static StringBuilder sb;

    static int N, M, V;

    static LinkedList<Integer>[] asList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        asList = new LinkedList[N +1];

        for(int i = 1; i <=N; i++){
            asList[i] = new LinkedList();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            asList[v1].add(v2);
            asList[v2].add(v1);
        }


        for(int i = 1; i <=N; i++){ // 모든 정점들이 자기 친구 찾을때 숫자 작은 친구부터 찾아야한다.
            Collections.sort(asList[i]);
        }

        dfs(V);
        System.out.println(sb);
        sb = new StringBuilder();
        visit = new boolean[N+1];
        bfs(V);
        System.out.println(sb);

    }


    public static void dfs(int v){

        visit[v] = true;
        sb.append(v).append(" ");

       for(int next : asList[v]){
           if(!visit[next]){
               dfs(next);
           }
       }

    }

    public static void bfs(int v){
        Queue<Integer> que = new LinkedList<>();

        que.add(v); //큐에 넣으면서 무조건 방문했다고 표시!! 왜냐면 다른 애도 그 애가 있을수도 있으니깐 무조건 큐에 방문하면 visit 체크 !!
        visit[v] =true;
        while(!que.isEmpty()){
            int k = que.poll();

            sb.append(k).append(" ");

            for(int next : asList[v]){
                if(!visit[next]){
                    visit[next] = true; //큐에 넣는거는 방문했다고 표시를 해줘야함
                    que.add(next);
                }
            }
        }

    }
}
