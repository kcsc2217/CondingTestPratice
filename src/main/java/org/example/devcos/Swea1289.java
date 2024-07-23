package org.example.devcos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea1289 {
    // 원재의 메모리 복구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int testCase = Integer.parseInt(br.readLine());


        for(int t = 1; t <=testCase; t++){
            String str = br.readLine();  // 숫자 입력받기

             int size = str.length();

             int count = 0;


             int result[] = new int[size];
             int arr[] = new int[size];

            Arrays.fill(arr, 0); // 해당 배열 0으로 채우기

            for(int i = 0; i < size; i++){
                result[i] = str.charAt(i) - '0'; // 배열 숫자로 채우기
            }

            for(int i = 0; i < size; i++){
                if(arr[i] != result[i]){
                    for(int j = i; j < size; j++){
                        arr[j] = result[i];

                    }
                    count++;
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");


        }

        System.out.println(sb);

    }

}
