package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for(int val : arr){
            answer += val;
        }
      answer = answer / arr.length;
        return answer;
    }
}