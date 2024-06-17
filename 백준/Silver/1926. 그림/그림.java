import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] art;
    static boolean[][] isVisited;
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로

        art = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < m; j++) {
                art[i][j] = input[j];
            }
        }

        int max = 0;
        int artCnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!isVisited[i][j] && art[i][j] == 1) {
                    artCnt++;
                    int count = DFS(i, j);
                    if(count > max) {
                        max = count;
                    }
                }
            }
        }

        System.out.println(artCnt);
        System.out.println(max);
    }

    public static int DFS(int x, int y) {
        isVisited[x][y] = true;
        int cnt = 1;

        for(int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !isVisited[nextX][nextY] && art[nextX][nextY] == 1) {
                cnt += DFS(nextX, nextY);
            }
        }
        return cnt;
    }
}
