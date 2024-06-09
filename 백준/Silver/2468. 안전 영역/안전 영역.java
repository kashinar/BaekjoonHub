import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int x, y;
    static int[][] area;
    static boolean[][] isVisited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());

        x = y = width;

        area = new int[y][x];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < y; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0;  j < x; j++) {
                area[i][j] = input[j];
                if (input[j] > max) {
                    max = input[j];
                }

            }
        }

        int cntMax = 1;

        for(int height = 0; height <= max; height++) {
            isVisited = new boolean[y][x];
            cnt = 0;

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (!isVisited[i][j] && area[i][j] > height) {
                        cnt++;
                        DFS(i, j, height);

                    }
                }
            }

            cntMax = Math.max(cntMax, cnt);
        }

        System.out.println(cntMax);

    }

    public static void DFS(int w, int h, int rain) {
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        isVisited[w][h] = true;

        for(int[] d : direction) {
            int nextX = w + d[0];
            int nextY = h + d[1];

            if(nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && !isVisited[nextX][nextY] && area[nextX][nextY] > rain) {
                isVisited[nextX][nextY] = true;
                DFS(nextX, nextY, rain);
            }
        }
    }
}
