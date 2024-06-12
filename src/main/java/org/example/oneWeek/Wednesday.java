package org.example.oneWeek;

import java.util.LinkedList;
import java.util.Queue;

public class Wednesday {

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> queue = new LinkedList<>();

            int time = 0;
            int sum = 0;


            for (int i = 0; i < truck_weights.length; i++) {
                int truckWeight = truck_weights[i];

                while (true) {
                    if (queue.isEmpty()) { // 큐가 비어있을때
                        queue.add(truckWeight);
                        sum += truckWeight;
                        time++;
                        break;
                    } else if (queue.size() == bridge_length) {
                        sum -= queue.poll();
                    } else {
                        if (sum + truckWeight <= weight) {
                            queue.add(truckWeight);
                            sum += truckWeight;
                            time++;
                            break;
                        } else {
                            queue.add(0);
                            time++;
                        }
                    }
                }


            }
            return time + bridge_length;
        }
    }
}
