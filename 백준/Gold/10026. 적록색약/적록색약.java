import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] color;
    static boolean[][] isVisited;
    static Queue<int[]> area;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        color = new String[N][N];;
        isVisited = new boolean[N][N];
        area = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < N; i++) {
            String[] inputData = br.readLine().split("");
            for(int j = 0; j < inputData.length; j++) {
                //색맹이 아닌 배열에는 모든 색상을 추가
                color[i][j] = inputData[j];
            }
        }

        for(int i = 0; i < color.length; i++) {
            for(int j = 0; j < color[i].length; j++) {
                //현재 색깔을 취득
                String current = color[i][j];
                //방문하지 않은 좌표라면 탐색 시작 <- BFS함수 내에서 같은 색깔 덩어리만 보게 됨
                if(!isVisited[i][j]) {
                    //좌표와 현재 색깔을 함수로 건네줌
                    BFS(i, j, current);
                    count++; //BFS가 한번 실행될 때마다 하나의 색깔 구간이므로..
                }
            }
        }

        //색약일 경우..
        int blindCnt = 0;
        //방문 상태 초기화
        isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                //색약인 배열은 초록을 빨강으로 변경
                if(color[i][j].equals("G")) {
                    color[i][j] = "R";
                }
            }
        }

        for(int i = 0; i < color.length; i++) {
            for(int j = 0; j < color[i].length; j++) {
                //현재 색깔을 취득
                String current = color[i][j];
                //방문하지 않은 좌표라면 탐색 시작 <- BFS함수 내에서 같은 색깔 덩어리만 보게 됨
                if(!isVisited[i][j]) {
                    //좌표와 현재 색깔을 함수로 건네줌
                    BFS(i, j, current);
                    blindCnt++; //BFS가 한번 실행될 때마다 하나의 색깔 구간이므로..
                }
            }
        }

        System.out.println(count + " " + blindCnt);
    }

    private static void BFS(int a, int b, String current) {
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        //첫 시작 좌표 추가
        area.add(new int[]{a,b});

        //탐색 while문
        while(!area.isEmpty()) {
            int[] point = area.poll();
            int x = point[0];
            int y = point[1];

            isVisited[x][y] = true;

            for(int i = 0; i < direction.length; i++) {
                int nextX = x + direction[i][0];
                int nextY = y + direction[i][1];

                //범위 내이며 방문하지 않은 경우
                if(nextX < N && nextY < N && nextX >=0 && nextY >=0 && isVisited[nextX][nextY] == false){
                    //다음 색깔을 획득
                    String nextColor = color[nextX][nextY];
                    //다음 색깔이 현재 찾고자 하는 색깔과 같을 경우만 탐색 좌표를 추가
                    if(nextColor.equals(current)) {
                        int[] nextPoint = {nextX, nextY};
                        isVisited[nextX][nextY] = true;
                        area.add(nextPoint);
                    }
                }
            }
        }
    }
}
