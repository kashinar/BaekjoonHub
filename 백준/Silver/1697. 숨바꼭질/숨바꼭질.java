import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        isVisited = new boolean[100001];

        BFS(start, end);

        System.out.println(dist[end]);
    }

    public static void BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            if(current == end) {
                return;
            }
            int[] nextposition = {current * 2, current + 1, current -1};
            for(int next : nextposition) {
                if(next >= 0 && next <= 100000 && !isVisited[next]) {
                    q.add(next);
                    isVisited[next] = true;
                    dist[next] = dist[current] + 1;
                }
            }
        }
    }
}
