import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int[][] cave;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        int cnt = 1;

        while(!((input = br.readLine()).equals("0"))) {
            int N = Integer.parseInt(input);

            //동굴은 NxN이므로..
            cave = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cost = Dijkstra(N);

            System.out.println("Problem " + cnt + ": " + cost);
            cnt++;
        }
    }

    public static int Dijkstra(int N) {
        Queue<Node> pq = new PriorityQueue<>();
        int[][] dist = new int[N][N];
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};

        //이동하는 거리를 전부 최대값으로
        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.add(new Node(0,0, cave[0][0]));
        dist[0][0] = cave[0][0];

        while(!pq.isEmpty()) {
            Node position = pq.poll();
            int x = position.x;
            int y = position.y;
            int cost = position.cost;

            //제일 끝점에 도달했다면..
            if(x == N-1 && y == N-1) {
                return cost;
            }

            for(int i = 0; i < move.length; i++) {
                int nX = x + move[i][0];
                int nY = y + move[i][1];

                if(nX < 0 || nX > N-1 || nY < 0 || nY > N-1) continue;
                //현재 코스트 + 다음 위치가 지금까지 이동한 최소보다 더 작을때
                if(cost + cave[nX][nY] < dist[nX][nY]) {
                    dist[nX][nY] = cost + cave[nX][nY];
                    pq.add(new Node(nX, nY, cost + cave[nX][nY]));
                }
            }
        }

        return -1;
    }
}
