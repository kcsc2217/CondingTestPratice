package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 수 T 입력
        int testCase = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 대한 처리
        for (int t = 1; t <= testCase; t++) {
            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken()); //높이
            int W = Integer.parseInt(st.nextToken()); // 넓이

            char[][] arr = new char[H][W]; // 초기화 할 배열

            for (int i = 0; i < H; i++) {
                String str = br.readLine();

                for (int j = 0; j < W; j++) {
                    arr[i][j] = str.charAt(j);
                }
            } // 배열 초기화

            int N = Integer.parseInt(br.readLine()); // 칸의 수


            String moveStr = br.readLine(); // 컨트롤

            battle(H, W, N, arr, moveStr);

            for(int j = 0; j < H; j++){
                for(int k =0; k < W; k++) {
                    System.out.print(arr[j][k]);
                }
                System.out.println();
                }


            // 결과 출력


        }
    }

    public static void battle(int H, int W, int N, char[][] arr, String str){
        for(int i = 0; i < N; i++){
            char aw = str.charAt(i);

            if(aw == 'S'){  //슈팅 쏠때
                for(int j = 0; j < H; j++){
                    for(int k =0; k < W; k++){
                        if(arr[j][k] == '<'){  //좌측일떄

                            for(int s = k-1; s >=0; s--){
                                if(arr[j][s] == '*'){
                                    arr[j][s] = '.';
                                    break;
                                }

                                if(arr[j][s] == '#'){
                                    break;
                                }
                            }
                        }

                        else if(arr[j][k] == '>'){  //좌측일떄

                            for(int s = k+1; s < W; s++){
                                if(arr[j][s] == '*'){
                                    arr[j][s] = '.';
                                    break;
                                }

                                if(arr[j][s] == '#'){
                                    break;
                                }
                            }
                        }

                        else if(arr[j][k] == 'v'){  //좌측일떄

                            for(int s = j+1; s < H ; s++){
                                if(arr[s][k] == '*'){
                                    arr[s][k] = '.';
                                    break;
                                }

                                if(arr[s][k] == '#'){
                                    break;
                                }
                            }
                        }

                        else{
                            for(int s = j-1; s >= 0; s--){
                                if(arr[s][k] == '*'){
                                    arr[s][k] = '.';
                                    break;
                                }

                                if(arr[s][k] == '#'){
                                    break;
                                }
                            }

                        }
                    }
                }
            }

            //슈팅 끝------------------------------

            // 이제 이동 -----------------------

            else if(aw == 'U'){

                L :for(int j = 0; j < H; j++) { // 이중반복문이여서 탈출 조건 달아주기
                    for (int k = 0; k < W; k++) {
                        if(arr[j][k] == '<' || arr[j][k] == '>' || arr[j][k] == '^' || arr[j][k] == 'v'){
                            arr[j][k] = '^';
                            if(j -1 >= 0 && arr[j-1][k] =='.'){
                                arr[j-1][k] = arr[j][k];
                                arr[j][k] = '.';
                                break L;  //이동 한 부분이 겹칠수도 있으므로
                            }

                        }

                    }
                }
            }

            else if(aw == 'D'){

                L :for(int j = 0; j < H; j++) { // 이중반복문이여서 탈출 조건 달아주기
                    for (int k = 0; k < W; k++) {
                        if(arr[j][k] == '<' || arr[j][k] == '>' || arr[j][k] == '^' || arr[j][k] == 'v'){
                            arr[j][k] = 'v';
                            if(j +1 < H && arr[j+1][k] =='.'){
                                arr[j+1][k] = arr[j][k];
                                arr[j][k] = '.';

                                break L;
                            }

                        }

                    }
                }
            }

            else if(aw == 'L'){

                L :for(int j = 0; j < H; j++) { // 이중반복문이여서 탈출 조건 달아주기
                    for (int k = 0; k < W; k++) {
                        if(arr[j][k] == '<' || arr[j][k] == '>' || arr[j][k] == '^' || arr[j][k] == 'v'){
                            arr[j][k] = '<';
                            if(k-1 >= 0 && arr[j][k-1] =='.'){
                                arr[j][k-1] = arr[j][k];
                                arr[j][k] = '.';

                                break L;
                            }

                        }

                    }
                }
            }

            else{

                L :for(int j = 0; j < H; j++) { // 이중반복문이여서 탈출 조건 달아주기
                    for (int k = 0; k < W; k++) {
                        if(arr[j][k] == '<' || arr[j][k] == '>' || arr[j][k] == '^' || arr[j][k] == 'v'){
                            arr[j][k] = '>';
                            if(k+1 < W && arr[j][k+1] =='.'){
                                arr[j][k+1] = arr[j][k];
                                arr[j][k] = '.';

                                break L;
                            }

                        }

                    }
                }

            }







        }
    }



}


