import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++) {
            int value =  Integer.parseInt(br.readLine());
            pq.add(value);
        }

        int count = 0;

        while(true) {
            int current = pq.poll();

            while(current <= K) {
                K = K - current;
                count++;
            }

            if(K == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
