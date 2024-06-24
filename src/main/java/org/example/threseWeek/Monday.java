package org.example.threseWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Monday {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        } // 정렬

        Collections.sort(list);

        int sum = 0;

        int result = 0;


        for(int i = 0; i < list.size();i++){
            sum+= list.get(i);

            result += sum;
        }

        sb.append(result);


        System.out.println(sb);


    }



}
