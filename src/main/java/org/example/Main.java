package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
         StringBuilder sb = new StringBuilder();
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         List<Integer> list = new ArrayList<>();

         for(int i = 0; i < n; i++){
             list.add(Integer.parseInt(st.nextToken()));
         }

         Collections.sort(list,Collections.reverseOrder()); // 그리디 알고리즘을 사용하기  위하여


         int sum = 0;
         int pre_level = list.get(0); //  가장 레벨이 높은 값을 맨 앞 값으로 둠

         for(int i = 1; i < n; i++){
             sum += pre_level + list.get(i);  // 레벨끼리 합하여 총합에 담아둠
             if(pre_level <= list.get(i)){ // 전의 레벨과 합해야할 레벨을 비교하여 더 큰 값이 기준 레벨로 잡는다.
                 pre_level = list.get(i);
             }
         }

         sb.append(sum);



        System.out.println(sb);


    }



}









