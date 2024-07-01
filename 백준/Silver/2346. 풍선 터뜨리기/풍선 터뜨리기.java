import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Deque;

public class Main {
    static class Balloon {
        int idx;
        int num;

        public Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] direction = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            direction[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Balloon> dq = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            dq.add(new Balloon(i, direction[i - 1]));
        }

        StringBuilder sb = new StringBuilder();

        //첫번째 풍선 선택
        Balloon current = dq.pollFirst();
        int next = current.num;
        sb.append(current.idx + " ");

        while(!dq.isEmpty()) {
            if(next > 0) {
                //양수일때
                for(int i = 1; i < next; i++) {
                    dq.addLast(dq.pollFirst());
                }
                current = dq.pollFirst();
            } else {
                //음수일때
                for(int i = 1; i < Math.abs(next); i++) {
                    dq.addFirst(dq.pollLast());
                }
                current = dq.pollLast();
            }

            next = current.num;
            sb.append(current.idx + " ");
        }

        System.out.println(sb.toString().trim());
    }

}
