package org.example;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right= times[times.length-1] * (long)n; // 주어진 n이 입국심사를 가장 늦게 받을 시간

        while(left <= right){
            long mid = (left + right) / 2;
            long result = 0;


            for(int time : times){
                result += mid / time;
            }

            if(result < n){
                left  = mid+1;
            }
            else{
                answer = mid;
                right = mid-1;
            }
        }


        return answer;
    }
}
