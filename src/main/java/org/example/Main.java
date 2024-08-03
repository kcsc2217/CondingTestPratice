package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int arr[][];
    static boolean visit[][];
    static StringBuilder sb;

    static int dx[] ={-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    // 이동 좌표 상하 좌우

    static int aw = 0;


    static int N;


    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          sb = new StringBuilder();

          N = Integer.parseInt(br.readLine());

          arr = new int[N][N];
          visit = new boolean[N][N];


          for(int i = 0; i < N; i++){
              String str = br.readLine();
              for(int j = 0; j < N; j++){
                  arr[i][j] = str.charAt(j) - '0';
              }
          }
          List<Integer> list = new ArrayList<>();


          for(int i = 0; i < N; i++ ){
              for(int j = 0; j < N; j++){
                  if(!visit[i][j] && arr[i][j] == 1){
                      bfs(i, j);
                      list.add(aw);
                      aw = 0;
                  }
              }
          }

          Collections.sort(list);

        System.out.println(list.size());

        for(int i : list){
            System.out.println(i);
        }

    }

         public static void dfs(int i, int j){
            visit[i][j] = true;
            aw++;
            //방문하면 쌓기


            for(int k = 0;  k < 4; k++){
                int next_x = i + dx[k];
                int next_y = j + dy[k];

                if(next_x >=0 && next_x < N && next_y >=0 && next_y < N){ // 즉 네모 안의 범위에 속하면
                    if(!visit[next_x][next_y] && arr[next_x][next_y] == 1){
                        dfs(next_x, next_y);
                    }
                }
            }

         }

    public static void bfs(int i, int j){
        Queue<Node> queue = new LinkedList<>();

        visit[i][j] = true;
        aw++;

        queue.add(new Node(i,j));


        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();


            for(int k = 0; k < 4; k++){
             int next_x = x + dx[k];
             int next_y = y + dy[k];

                if(next_x >=0 && next_x < N && next_y >=0 && next_y < N){ // 즉 네모 안의 범위에 속하면
                    if(!visit[next_x][next_y] && arr[next_x][next_y] == 1){  //방문했다의 의미: 큐에 있다 !!
                       visit[next_x][next_y] = true;
                       aw++;
                       queue.add(new Node(next_x, next_y));
                    }
                }
            }
        }


    }



    }
    class Node{ // 큐에 x, y 좌표 둘다 관리하기 위해 넣어줬다.
    int x;
    int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }












