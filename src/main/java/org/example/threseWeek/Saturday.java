package org.example.threseWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Saturday {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //남학생 수
        int M = Integer.parseInt(st.nextToken()); // 여학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴쉽 인원

        int count = 0;


        while(N >= 2 && M >=1 && (N+M)- K >= 3){
            count++;
            N -=2;
            M--;
        }

        System.out.println(count);



    }

}
