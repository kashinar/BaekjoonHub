import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int min_time = Integer.MAX_VALUE;
    static int[] isVisited;
    static int subin, sister;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());
        
        if(subin >= sister) {
            System.out.println((subin - sister) + "\n1");
            return;
        }

        isVisited = new int[100001];

        BFS();

        System.out.println(min_time + "\n" + count);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(subin);
        isVisited[subin] = 1;

        while(!q.isEmpty()) {
            int current = q.poll();

            if(min_time < isVisited[current]) return;

            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 0)      next = current + 1;
                else if(i == 1) next = current - 1;
                else            next = current * 2;

                if(next < 0 || next > 100000) continue;

                if(next == sister) {
                    min_time = isVisited[current];
                    count++;
                }

                if(isVisited[next] == 0 || isVisited[next] == isVisited[current] + 1) {
                    q.add(next);
                    isVisited[next] = isVisited[current] + 1;
                }
            }
        }
    }
}
