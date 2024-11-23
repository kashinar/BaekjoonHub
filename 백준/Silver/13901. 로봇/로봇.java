import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static boolean[][] isVisited;
    static boolean[][] obstacle;
    static String[] sDirection;
    static int R, C, sr, sc;
    static Queue<Integer> direction;
    static int[][] move = {{},{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        //Room size
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //init
        isVisited = new boolean[R][C];
        obstacle = new boolean[R][C];
        direction = new LinkedList<>();

        //Number of obstacle
        int k = Integer.parseInt(input.readLine());

        //reply obstacle
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(input.readLine());
            int br = Integer.parseInt(st.nextToken());
            int bc = Integer.parseInt(st.nextToken());
            obstacle[br][bc] = true;
        }

        //get start point
        st = new StringTokenizer(input.readLine());
        sr = Integer.parseInt(st.nextToken()); //세로
        sc = Integer.parseInt(st.nextToken()); //가로

        sDirection = input.readLine().split(" ");
        for(String d : sDirection) {
            direction.add(Integer.parseInt(d));
        }


        isVisited[sr][sc] = true;

        //처음 방향을 취득
        int current_direction = direction.poll();

        //로봇을 작동 -> 더 이상 움직일 곳이 없을때까지
        while(true) {
            boolean isMove = false;
            //모든 방향 4번을 시도해야되니 4번 반복
            for(int i = 0; i < 4; i++) {
                int nextX = sr + move[current_direction][0];
                int nextY = sc + move[current_direction][1];

                if(0 <= nextX && 0 <= nextY && nextX < R && nextY < C && !isVisited[nextX][nextY] && !obstacle[nextX][nextY]) {
                    //이동할 수 있으면 현재 위치값 갱신
                    isVisited[nextX][nextY] = true;
                    sr = nextX;
                    sc = nextY;
                    isMove = true;
                }  else {
                    //이동 불가능 하면 다음 방향 지정
                    direction.add(current_direction);
                    current_direction = direction.poll();
                }
            }

            if(!isMove) break;
        }

        System.out.println(sr + " " + sc);
    }
}