package org.example.oneWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Friday {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int arr[] = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long end = arr[K-1];

        long start = 1;

        long result = 0;

        while(start <= end){
            long sum = 0;
            long mid = (start+ end) / 2;

            for(int i =0; i < K; i++){

                sum += arr[i] / mid;

            }

            if(sum < N){
                end = mid-1;
            }
            else{
                result = mid;
                start = mid+1;
            }


        }

        System.out.println(result);

    }
}
