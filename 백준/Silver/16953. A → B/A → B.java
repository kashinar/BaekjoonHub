import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = Integer.MAX_VALUE;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        isVisited = new boolean[B];

        DFS(A, B, 0);

        if(cnt == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(cnt + 1);
        }
    }

    public static void DFS(int target, int num, int count) {
        if(num < target) {
            return;
        }

        if(num == target) {
            cnt = Math.min(cnt, count); //최소 횟수 갱신
            return;
        }

        if(num % 2 == 0) {
            DFS(target, num / 2, count + 1);
        }

        if(num % 10 == 1) {
            DFS(target, num / 10, count + 1);
        }
    }
}
