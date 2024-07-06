package org.example.lastWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saturday {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number[] = {1,2,3};


        int testCase = Integer.parseInt(br.readLine());

        int dp[][] = new int[100001][4];
        dp[1][1] = 1; //1
        dp[2][1] = 1; // 1+1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; //1+1+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; // 3;

        for(int i =4 ; i <=10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int t = 0;  t < testCase; t++){
            int N = Integer.parseInt(br.readLine());
            int sum = dp[N][1] + dp[N][2] + dp[N][3];
            sb.append(sum).append("\n");

        }

        System.out.println(sb);

    }
}
