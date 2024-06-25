import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Knight {
        int x;
        int y;
        int cost;

        public Knight(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int[][] chess;
    static boolean[][] isVisited;
    static int[][] direction = {{-2,1},{-1,2},{1,2},{2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++) {
            int l = Integer.parseInt(br.readLine()); //체스판 변의 길이
            chess = new int[l][l];
            isVisited = new boolean[l][l];

            //나이트의 좌표
            st = new StringTokenizer(br.readLine());
            int knightX = Integer.parseInt(st.nextToken());
            int knightY = Integer.parseInt(st.nextToken());

            //도착 지점의 좌표
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<Knight> q = new LinkedList<>();
            q.add(new Knight(knightX,knightY,0));
            isVisited[knightX][knightY] = true;

            while(!q.isEmpty()) {
                Knight current = q.poll();
                int currentx = current.x;
                int currenty = current.y;
                int currentcost = current.cost;

                if (currentx == endX && currenty == endY) {
                    System.out.println(currentcost);
                    break;
                }

                for(int[] d : direction) {
                    int nextX = currentx + d[0];
                    int nextY = currenty + d[1];

                    if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !isVisited[nextX][nextY]) {
                        q.add(new Knight(nextX, nextY, currentcost + 1));
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
