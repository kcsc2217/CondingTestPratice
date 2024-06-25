package org.example;




class Solution {

    public  int solution(int k, int[] limits, int[][] sockets) {

        int a[] = new int[sockets.length];

        int answer = 0;



        for(int i = sockets.length-1; i >= 0; i--){
            int sum = 0;
            for(int j = 0; j < sockets[i].length; j++){
                if(sockets[i][j] == -1){
                    sum +=k; // -1이면 k 만큼 sum 에 더해준다
                }
               else if (sockets[i][j] != 0){
                   int n = sockets[i][j]; // 숫자면

                   sum +=a[n-1];
                }
            }

            if(sum > limits[i]){
                while(sum >=limits[i]){ // 뽑는 행위
                  sum -= k;
                  answer++;
                }


            }
            a[i] = sum;
        }

        return answer;
    }
}