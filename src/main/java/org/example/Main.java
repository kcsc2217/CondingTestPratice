package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            int N = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < N ;i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");


                String command = st.nextToken();



                switch (command){

                    case "push":
                        int number = Integer.parseInt(st.nextToken());
                        stack.push(number);
                        break;
                    case "pop":
                        if(!stack.empty()){
                            sb.append(stack.pop()).append("\n");
                            break;
                        }else{
                            sb.append(-1).append("\n");
                            break;
                        }
                    case "size":
                        sb.append(stack.size()).append("\n");
                        break;

                    case "empty":
                        if(stack.empty()){
                            sb.append(1).append("\n");
                            break;
                        }else {
                            sb.append(0).append("\n");
                            break;
                        }
                    default:
                        if(!stack.empty()){
                            sb.append(stack.peek()).append("\n");
                            break;
                        }else {
                            sb.append(-1).append("\n");
                            break;
                        }
                }
            }

            System.out.println(sb);






    }
}