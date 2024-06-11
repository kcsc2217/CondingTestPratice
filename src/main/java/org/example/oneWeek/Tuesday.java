package org.example.oneWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tuesday {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i <= N; i++){
            q.add(i);
        }

        sb.append("<");

        while(!q.isEmpty()){
            for(int i = 0; i < K-1; i++){
                Integer frontN = q.poll();
                q.add(frontN);
            }



            if(q.size() ==1 ){
                sb.append(q.poll()).append(">");
            }else{
                sb.append(q.poll()).append(", ");
            }
        }

        System.out.println(sb);


    }
}
