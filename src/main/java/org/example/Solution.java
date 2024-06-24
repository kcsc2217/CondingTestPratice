package org.example;

import java.util.ArrayList;

import java.util.List;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
           int aw =  100 -progresses[i];

           int val = aw / speeds[i];

           if(aw % speeds[i] != 0){
               val++;
           }

           q.add(val);
        }
        List<Integer> list = new ArrayList<>();

        int count = 1;

        int x = q.poll();

        while(!q.isEmpty()){
            if(x >=q.peek()){
                count++;
                q.poll();
            }else{
                list.add(count);
                count = 1;
                x = q.poll();
            }
        }
        list.add(count);



        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}