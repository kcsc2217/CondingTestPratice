package org.example.lastWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Friday {
    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());

            int arr[][] = new int[N+2][2]; // N일때 T가 1이면 일을 할 수 있는 상황이므로 그리고 1일 부터 신청하므로

            int dp[] = new int[N+2];

            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                arr[i][0] = Integer.parseInt(st.nextToken()); // 상담을 하는데 걸리는 시간
                arr[i][1] = Integer.parseInt(st.nextToken());  // 상담 비용
            }


            int max = -1;


            for(int i = 1; i < N+2; i++){
                if(max < dp[i]){
                    max = dp[i]; // 누적의 합을 더할 예정
                }

                int time = i + arr[i][0];

                if(time < N +2){
                    dp[time] = Math.max(dp[time], max + arr[i][1]); // 해당 누적의 합과 상담 비용을 더함
                }
            }
            System.out.println(dp[N+1]);



        }

    }



}
