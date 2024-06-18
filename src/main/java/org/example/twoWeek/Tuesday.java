package org.example.twoWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tuesday {
    static int dx[] = {-1, 1 ,0, 0}; // 상 하 좌우 로 이동할 x좌표
    static int dy[] = {0, 0 ,-1, 1}; // 상 하 좌우 로 이동할 y좌표
    static int N;
    static int map[][];

    static int count = 0;

    static List<Integer> list = new ArrayList<>();

    static boolean visit[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i =0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        } // 배열 초기화



        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    list.add(count);
                    count = 0;}
            }
        }

        sb.append(list.size()).append("\n");
        Collections.sort(list);

        for(Integer i : list){
            sb.append(i).append("\n");
        }


        System.out.println(sb);




    }

    private static void dfs(int x, int y){
        visit[x][y] = true;
        count++;

        for(int j = 0; j < 4; j++){
            int now_x =  x + dx[j]; //상하좌우
            int now_y = y+ dy[j];  // 상하좌우

            if(now_x >=0 && now_x <N && now_y >= 0 &&now_y < N){ // 배열의 경계선 체크

                if(!visit[now_x][now_y] && map[now_x][now_y] == 1){ // 배열 경계선 체크해줌
                    dfs(now_x, now_y);
                }

            }


        }
    }
}
