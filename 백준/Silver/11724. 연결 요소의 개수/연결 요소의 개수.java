import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int V,E;
    static int[][] relation;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        relation = new int[V+1][V+1];
        isVisited = new boolean[V+1];
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            relation[start][end] = 1;
            relation[end][start] = 1;
        }

        int count = 0;

        for(int i = 1; i <= V; i++) {
            if(!isVisited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void DFS (int currentNode) {
        isVisited[currentNode] = true;

        for(int next = 1; next <= V; next++) {
            if(!isVisited[next] && relation[currentNode][next] == 1) {
                DFS(next);
            }
        }
    }

}
