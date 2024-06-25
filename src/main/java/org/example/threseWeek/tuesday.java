package org.example.threseWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class tuesday {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // 종료점을 기준으로 정렬

                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        }); // 정열

        int count = 0;
        int pre_end = 0;



        for(int i = 0; i < N; i ++){
            if(pre_end <= arr[i][0]){
                pre_end = arr[i][1];
                count ++;
            }
        }

        sb.append(count);


        System.out.println(sb);


    }
}
