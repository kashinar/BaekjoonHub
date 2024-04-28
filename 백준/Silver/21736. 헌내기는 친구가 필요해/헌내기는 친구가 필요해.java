import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static String[][] campus;
    public static Queue<int[]> doyeon; //도연이의 위치
    public static boolean[][] isVisited;
    public static int N; //가로 줄(행)
    public static int M; //세로 줄(열)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //행과 열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new String[N][M];
        isVisited = new boolean[N][M];
        doyeon = new LinkedList<int[]>();

        for(int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                campus[i][j] = strArr[j];

                //도연이의 최초 위치 파악
                if(campus[i][j].equals("I")) {
                    int[] coordinate = {i, j};
                    //도연이의 최초 위치추가
                    doyeon.add(coordinate);
                }
            }
        }

        int result = Search();
        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static int Search() {
        int[][] direction = {{0,1}, {0,-1}, {-1,0}, {1,0}}; //상하좌우
        int cnt = 0;

        while(!doyeon.isEmpty()) {
            int[] position = doyeon.poll();

            int x = position[0];
            int y = position[1];
            if(campus[x][y].equals("P")){
                cnt++; //방문 결과가 P일경우 카운트 업
            }

            for(int i = 0; i < direction.length; i++) {
                int nextX = x + direction[i][0];
                int nextY = y + direction[i][1];

                //캠퍼스 범위 설정, 방문하지 않은곳, X(벽)가 아닌곳일경우
                if(nextX < N && nextY < M && nextX >= 0 && nextY >=0 && isVisited[nextX][nextY] == false && !campus[nextX][nextY].equals("X")) {
                    int[] nextFreind = {nextX, nextY};

                    isVisited[nextX][nextY] = true;
                    doyeon.add(nextFreind);
                }
            }
        }

        return cnt;
    }
}
