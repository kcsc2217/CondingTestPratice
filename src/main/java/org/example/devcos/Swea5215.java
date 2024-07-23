package org.example.devcos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5215 {

    //햄버거 다이어트
    static int N , L, max;
    static int[] kcal, total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());


        for(int t = 1; t<= testCase; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            kcal = new int[N];
            total = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                total[i] = Integer.parseInt(st.nextToken()); // 칼로리 초기화
                kcal[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;

            dfs(0, 0, 0);


            System.out.printf("#%d %d\n", t, max);


        }


    }


    private static void dfs(int cnt, int j, int k){
        if(k > L){
            return;
        }

        if(cnt ==N){
            max = Math.max(max, j);

            return;
        }

        dfs(cnt+1, j + total[cnt], k + kcal[cnt]); //다음꺼 포한한 로직
        dfs(cnt+1, j, k); // 포함하지 않은 로직
    }

}
