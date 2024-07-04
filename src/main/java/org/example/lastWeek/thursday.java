package org.example.lastWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class thursday {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int max = 987654321;

        String str = br.readLine();

        int dp[] = new int[N];

        char[] arr = new char[N];

        for(int i = 0; i < N; i++){
            arr[i] = str.charAt(i);
        }


        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 0; i < N-1; i++){
            int now = i;
            char now_ch = arr[now];
            for(int j = i+1; j < N; j++){
                int next = j;
                char next_ch = arr[next];

                if(now_ch == 'B' && next_ch == 'O'){  // 글자가 B이면서 다음 글자가 점플 할 수 있으면
                    dp[next] = Math.min(dp[next], dp[now] + (next-now) * (next-now));

                }

                if(now_ch == 'O' && next_ch == 'J'){  // 글자가 O이면서 다음 글자가 점플 할 수 있으면
                    dp[next] = Math.min(dp[next], dp[now] + (next-now) * (next-now));

                }

                if(now_ch == 'J' && next_ch == 'B'){  // 글자가 B이면서 다음 글자가 점플 할 수 있으면
                    dp[next] = Math.min(dp[next], dp[now] + (next-now) * (next-now));

                }
            }


        }



        if(dp[N-1] == max){
            System.out.println(-1);
        }else{
            System.out.println(dp[N-1]);
        }



    }
}
