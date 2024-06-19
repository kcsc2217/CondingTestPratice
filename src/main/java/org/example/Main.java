package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int dx[] = {-1, 1 ,0, 0}; // 상 하 좌우 로 이동할 x좌표
    static int dy[] = {0, 0 ,-1, 1}; // 상 하 좌우 로 이동할 y좌표
    static int N; //가로의 길이
    static int M; // 세로의 길이

    static int K; // 배추가 심어져 있는 위치 갯수

    static int map[][];

    static boolean visit[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int count = 0;

            N = Integer.parseInt(st.nextToken()); //가로 길이
            M = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 심어져 있는 위치 갯수

            map = new int[N][M]; // 배추가 들어갈 배열 초기화
            visit = new boolean[N][M]; // 방문 배추를 체크하기 위한 배열 초기화

            for(int j =0; j < K; j++ ){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(!visit[j][k] && map[j][k] == 1){
                        count++;
                        dfs(j,k);
                    }
                }
            }

            sb.append(count).append("\n");




        }

        System.out.println(sb);


    }

    private static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int now_x = x + dx[i];
            int now_y = y + dy[i];


            if(now_x >=0 && now_x < N && now_y >=0 && now_y < M ){
                if(map[now_x][now_y] == 1 && !visit[now_x][now_y]){
                    dfs(now_x, now_y);
                }
            }
        }

    }

    private static void bfs(int x, int y){
        Queue<Integer> xQue = new LinkedList<>();
        Queue<Integer> yQue = new LinkedList<>();


        visit[x][y] =true;

        xQue.add(x);
        yQue.add(y);

        while(!xQue.isEmpty() && yQue.isEmpty()){
            int now_x = xQue.poll();
            int now_y = yQue.poll();

            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if(next_x >=0 && next_x < N && next_y >=0 && next_y < M ){
                    if(map[next_x][next_y] == 1 && !visit[next_x][next_y]){
                       xQue.add(next_x);
                       yQue.add(next_y);

                       visit[next_x][next_y] = true;
                    }
                }


            }
         }



    }



            }









