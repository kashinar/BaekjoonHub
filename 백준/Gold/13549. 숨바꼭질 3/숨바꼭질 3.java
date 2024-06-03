import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Path implements Comparable<Path>{
    int next;
    int cost;
    public Path(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Path o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static boolean[] isVisited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start == end) {
            System.out.println(0);
            return;
        }

        isVisited = new boolean[100001];
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        find(start, end);


        System.out.println(dist[end]);
    }

    static void find(int start, int end) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(start, 0));

        while(!pq.isEmpty()) {
            Path current = pq.poll();

            if(isVisited[current.next]) continue;
            isVisited[current.next] = true;

            //텔레포트는 비용이 0
            int teleport = current.next * 2;
            if(teleport <= 100000 && isVisited[teleport] == false && dist[teleport] > current.cost) {
                pq.add(new Path(teleport, current.cost));
                dist[teleport] = current.cost;
            }

            //앞으로 한칸은 비용이 1
            int pPosition = current.next + 1;
            if(pPosition <= 100000 && isVisited[pPosition] == false && dist[pPosition] > current.cost + 1) {
                pq.add(new Path(pPosition, current.cost + 1));
                dist[pPosition] = current.cost + 1;

            }

            //뒤로 한칸은 비용이 1
            int mPosition = current.next - 1;
            if(mPosition >= 0 && isVisited[mPosition] == false && dist[mPosition] > current.cost + 1) {
                pq.add(new Path(mPosition, current.cost + 1));
                dist[mPosition] = current.cost + 1;
            }
        }
    }
}
