package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st = new StringTokenizer(br.readLine()," ");

         int N = Integer.parseInt(st.nextToken());
         int S = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());


         st = new StringTokenizer(br.readLine(), " ");

        boolean dp[][] = new boolean[N+1][M+1];

         int arr[] = new int[N+1];

         for(int i = 1; i <= N; i++){
             arr[i] = Integer.parseInt(st.nextToken());
         }

         dp[0][S] = true;


         for(int i = 1; i <= N; i++){
            int v = arr[i];

             for(int j = 0; j <= M; j++){
                 if(dp[i-1][j]){
                     int up= j + v ;
                     int down = j - v;


                    if(up <= M ){
                        dp[i][up] = true;
                    }

                     if(0 <= down){
                         dp[i][down] = true;
                     }
                 }
             }


         }

         int max = -1;

        for(int i = M; i >=0 ; i--){
            if(dp[N][i]){
                max = i;
                break;
            }
        }

        System.out.println(max);



    }




}









