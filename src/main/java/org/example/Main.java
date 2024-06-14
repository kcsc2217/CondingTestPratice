package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
    
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

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









