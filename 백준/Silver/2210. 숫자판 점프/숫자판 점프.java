import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static Set<Integer> set = new HashSet<>();
    static int[][] number_plate;
    static StringBuilder sb;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //숫자판은 5x5고정
        number_plate = new int[5][5];
        //숫자판 채우기
        for(int i = 0; i < number_plate.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < number_plate[i].length; j++) {
                number_plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < number_plate.length; i++) {
            for(int j = 0; j < number_plate[i].length; j++) {
                sb = new StringBuilder();
                isVisited = new boolean[5][5];
                DFS(i, j);
            }
        }

        System.out.println(set.size());
    }

    public static void DFS(int a, int b) {
        if(sb.length() == 6) {
            //글자가 5글자가 채워졌으면, map에 넣고 return
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        //현재 숫자 추가
        sb.append(number_plate[a][b]);

        for(int i = 0; i < direction.length; i++) {
            int nextX = a + direction[i][0];
            int nextY = b + direction[i][1];

            if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
                DFS(nextX, nextY);
            }
        }

        sb.deleteCharAt(sb.length() - 1); //6번째 숫자 제거
    }
}
