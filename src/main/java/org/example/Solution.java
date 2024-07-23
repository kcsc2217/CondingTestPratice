package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {

    static int[] point, kcal;
    static int N, L, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        int testCase = Integer.parseInt(br.readLine());


        for(int t = 0; t < testCase; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;


             point = new int[N];
             kcal = new int[N];


            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                point[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());

            }

            dfs(0, 0, 0);


            System.out.printf("#%d %d\n", t+1, max);
        }




    }



    private static void dfs(int cnt, int j, int k){
        if(k > L) return;

        if (cnt == N) {
            if (j > max) {
                max = j; // 현재 점수누적합이 max보다 크면 max변경(조건3)
            }
            return;
        }


            dfs(cnt+1, j + point[cnt], k+ kcal[cnt]);
        dfs(cnt+1, j , k);


    }

}