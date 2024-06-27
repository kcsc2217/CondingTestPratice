package org.example.threseWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Thursday {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine())); // 요금 초기화
        }


        Collections.sort(list,Collections.reverseOrder());

        int result = 0;


        for(int i = 0; i < N; i++){
            int aw = list.get(i);
            if(aw <= K){
                result += K / aw;

                K %= aw;
            }


        }

        sb.append(result);





        System.out.println(sb);


    }

}
