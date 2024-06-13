package org.example.oneWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Thursday {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = arr[N-1]; //최대값 구하기

        int min = 0;






        while(min < max){
            int mid = (max + min) / 2;
            long length = 0;
            for(int i = 0; i < N; i++){



                if(arr[i] - mid > 0){
                    length  += (arr[i] - mid);
                }
            }


            if(length < M){
                max = mid;
            }

            else{
                min = mid+1;
            }



        }

        System.out.println(min - 1);


    }
}
