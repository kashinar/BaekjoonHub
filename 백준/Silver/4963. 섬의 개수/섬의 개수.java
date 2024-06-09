import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int cnt;
    static int[][] island;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                return;
            }

            island = new int[h][w];
            isVisited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < w; j++) {
                    island[i][j] = input[j];
                }
            }

            cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문하지 않았고, 육지일 경우
                    if (!isVisited[i][j] && island[i][j] == 1) {
                        cnt++;
                        Search(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void Search(int x, int y) {
        // 8방향 탐색
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            // 현재 좌표를 얻어옴
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 방문처리
            isVisited[currentX][currentY] = true;

            // 다음 좌표 계산
            for (int[] dir : direction) {
                int nextX = currentX + dir[0];
                int nextY = currentY + dir[1];

                if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !isVisited[nextX][nextY] && island[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
