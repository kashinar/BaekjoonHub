import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F,S,G,U,D;
    static int[] isVisited;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); //스타트링크의 총 층수
        S = Integer.parseInt(st.nextToken()); //강호의 위치
        G = Integer.parseInt(st.nextToken()); //스타트링크의 위치
        U = Integer.parseInt(st.nextToken()); //엘레베이터의 위로 올라갈수 있는 층 수
        D = Integer.parseInt(st.nextToken()); //엘레베이터의 아래로 내려갈수 있는 층 수

        isVisited = new int[F + 1]; //건물은 1층부터 시작하므로

        BFS(S);
    }


    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int current = q.poll();

                if(current == G) {
                    System.out.println(isVisited[current] - 1);
                }

                //위층으로
                if(current + U <= F && isVisited[current + U] == 0) {
                    isVisited[current + U] = isVisited[current] + 1;
                    q.add(current + U);
                }

                //아래층으로
                if(current - D > 0 && isVisited[current - D] == 0) {
                    isVisited[current - D] = isVisited[current] + 1;
                    q.add(current - D);
                }
            }
        }

        if(isVisited[G] == 0) {
            System.out.println("use the stairs");
        }
    }
}
