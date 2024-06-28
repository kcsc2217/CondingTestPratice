package org.example.threseWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Friday {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String N = br.readLine();

        validation(N);

        System.out.println(sb.toString());





    }

    public static void validation(String result){

        if(!result.contains("0")){ // 30의 배수 이므로 끝에가 0이여야 한다 0이 포함되어 있지 않으므로 -1
            System.out.println(-1);
            return;
        }else{
            List<Integer> list  = new ArrayList<>();

            int sum  =0;
            for(int i = 0; i < result.length(); i++){  // 주어진 숫자의 각 자리 수를 다 더해준다.
                int aw =  result.charAt(i) - '0';
                list.add(aw);
                sum += aw;
            }

            if(sum  % 3 != 0){ // 각자리수의 합이 3의 배수가 아니면 -1
                System.out.println(-1);
                return;
            }


            Collections.sort(list,Collections.reverseOrder()); //그리디 알고리즘 ( 즉 30의 배수중 가장 큰 수를 만들어야해서

            for(int i : list){
                sb.append(i);
            }


        }
    }

}
