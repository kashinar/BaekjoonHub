import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main  {

    static class Node implements Comparable<Node> {
        int vertex;
        public Node(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Node n) {
            return this.vertex - n.vertex;
        }

    }
    static List<ArrayList<Node>> list;
    static boolean[] isVisited;
    static int[] position;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점의 수
        int M = Integer.parseInt(st.nextToken()); //간선의 수
        int R = Integer.parseInt(st.nextToken()); //시작 정점

        //0은 사용하지 않기 때문에 +1
        isVisited = new boolean[N+1];
        position = new int[N+1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            //정점의 수만큼 리스트를 작성
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //정점 1
            int v = Integer.parseInt(st.nextToken()); //정점 2

            //무방향 그래프이므로 양쪽에 추가
            list.get(u).add(new Node(v));
            list.get(v).add(new Node(u));
        }

        //정점의 인접리스트를 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(position[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int start) {
        isVisited[start] = true;
        position[start] = cnt;

        for(int i = 0; i < list.get(start).size(); i++) {
            int next = list.get(start).get(i).vertex;
            if(isVisited[next] == false) {
                cnt++;
                DFS(next);
            }
        }
    }
}
