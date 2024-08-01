package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];


        Queue<Integer> que = new LinkedList<>(); //

        for(int i : prices){
            que.add(i);
        }


        int index = 0;

        while(!que.isEmpty()){
            int aw = que.poll();

            for(int i = n - que.size(); i < n; i++){

                if(prices[i] < aw){ //주식 가격이 떨어짐
                    answer[index]++;
                    break;
                }

                if(aw <= prices[i]){
                    answer[index]++;
                }

            }
            index ++;

        }

        return answer;
    }
}