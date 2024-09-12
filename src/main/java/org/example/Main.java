package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int N , S;

    static int count = 0;  // count 와 sum 초기화

    static int arr[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //N 과 S 초기화
        S = Integer.parseInt(st.nextToken());

        arr =new int[N]; //배열 초기화

        st = new StringTokenizer(br.readLine());

        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }  // arr배열 초기화


        dfs(0,0);

        System.out.println(S == 0 ? count -1 : count);

    }

    static void dfs(int i,  int sum){


        if(i == N){
            if(sum == S){
                count++;
            }
            return;
        }

        dfs(i+1, arr[i] + sum);  //선택
        dfs(i+1, sum);  // 선택 x    즉 sum은 축적 값

    }
}










