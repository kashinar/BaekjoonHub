import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int cost;
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }

}

public class Main {
    public static int[] dist;
    public static boolean[] isVisited;
    public static ArrayList[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); //정점의 개수
        int E = Integer.parseInt(st.nextToken()); //간선의 개수
        int K = Integer.parseInt(br.readLine());  //시작 정점의 번호

        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        //인접리스트 생성, 거리배열 최대값으로
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        //입력받은 간선 정보를 리스트에 추가
        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int current = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[current].add(new Node(nextNode, cost));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        //우선순위 큐를 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0)); //큐에 시작점 추가

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            //현재 노드에서 연결되있는 간선의 수 만큼 반복
            for(int i = 0; i < list[current.index].size(); i++) {
                Node next = (Node)list[current.index].get(i);

                //현재까지의 거리 + 다음 노드까지의 거리가 여태까지 연산한 거리보다 더 작을 경우
                if(dist[next.index] > current.cost + next.cost) {
                    //거리값 배열에 현재까지의 거리 + 다음 노드까지의 거리로 갱신
                    dist[next.index] = current.cost + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}
